package testnet.tcp03jframe;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by wuxiang
 * on 2018/4/30.
 */
public class TCPServer03 {
    public static void main(String[] args) {

        try{
            ServerSocket serverSocket = new ServerSocket(9003);
            while (true) {
                Socket socket = serverSocket.accept();
                TCPJFrame TCPJFrame = new TCPJFrame(0);
                ServerThread serverThread = new ServerThread(socket, TCPJFrame);
                serverThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
