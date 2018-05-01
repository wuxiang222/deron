package testnet.tcp02thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by wuxiang
 * on 2018/4/30.
 */
public class TCPServer2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9001);

        while (true) {
            Socket socket = serverSocket.accept();
            ServerThread serverThread = new ServerThread(socket);
            serverThread.start();
        }
    }
}
