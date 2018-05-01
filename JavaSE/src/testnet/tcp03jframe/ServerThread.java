package testnet.tcp03jframe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by wuxiang
 * on 2018/5/1.
 */
public class ServerThread extends Thread{
    private Socket socket;
    private TCPJFrame TCPJFrame;

    public ServerThread(Socket socket, TCPJFrame TCPJFrame) {
        this.socket = socket;
        this.TCPJFrame = TCPJFrame;
    }

    @Override
    public void run() {
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            TCPJFrame.printWriter = printWriter;
            // 服务器听筒，接收信息，回显
            while (true) {
                String info = bufferedReader.readLine();
                String str = null;
                if (TCPJFrame.jTextArea.getText() == null || "".equals(TCPJFrame.jTextArea.getText())) {
                    str = "Client:" + info;
                } else {
                    str = TCPJFrame.jTextArea.getText() + "\r\nClient:" + info;
                }
                TCPJFrame.jTextArea.setText(str);
                TCPJFrame.jTextArea.setCaretPosition(TCPJFrame.jTextArea.getDocument().getLength());
            }
        } catch (IOException e) {
//            e.printStackTrace();    /* java.net.SocketException: Connection reset */
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
