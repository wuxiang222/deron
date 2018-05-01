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
public class ServerThread extends Thread {
    private Socket socket;
    public ServerThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = bufferedReader.readLine();

            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println(line + " from server");
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
