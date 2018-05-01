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
public class TCPClient03 {
    public static void main(String[] args) {
        TCPJFrame clientJFrame = new TCPJFrame(1);
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 9003);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket
                    .getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            clientJFrame.printWriter = printWriter;

            // 客户端听筒，接收信息，回显
            while (true) {
                String info = bufferedReader.readLine();
                String str = null;
                if (clientJFrame.jTextArea.getText() == null || "".equals(clientJFrame.jTextArea.getText())) {
                    str = "Server:" + info;
                } else {
                    str = clientJFrame.jTextArea.getText() + "\r\nServer:" + info;
                }
                clientJFrame.jTextArea.setText(str);
                clientJFrame.jTextArea.setCaretPosition(clientJFrame.jTextArea.getDocument().getLength());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
