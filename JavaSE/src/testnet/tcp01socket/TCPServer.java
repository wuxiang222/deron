package testnet.tcp01socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by wuxiang
 * on 2018/4/30.
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        Socket socket = serverSocket.accept();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = bufferedReader.readLine();
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println( line + " sssssss from server");
        printWriter.flush();
        socket.close();
    }
}
