package testnet.tcp02thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by wuxiang
 * on 2018/4/30.
 */
public class TCPClient2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9001);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println("hello world ni hao.");
        printWriter.flush();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String fromServer = bufferedReader.readLine();
        System.out.println(fromServer);
        socket.close();
    }
}
