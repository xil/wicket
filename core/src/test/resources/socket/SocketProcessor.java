package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: shakhov
 * Date: 11/25/13
 * Time: 12:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class SocketProcessor {

    public static final int PORT = 3425;
    public static final String HOST = "127.0.0.1";

    public static String sendCommand(String command) {
        System.out.println("Attemping to connect to host " + HOST + " on port " + PORT + ".");
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket(HOST, PORT);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + HOST);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " + HOST);
            System.exit(1);
        }
        String fromServer = null;
        try {
            String userInput = command;
            out.println(userInput);
            fromServer = in.readLine();
            System.out.println("echo: " + fromServer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
                echoSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fromServer;
    }
}
