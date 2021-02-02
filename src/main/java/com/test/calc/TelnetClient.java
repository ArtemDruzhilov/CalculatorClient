package com.test.calc;

import java.io.*;
import java.net.Socket;

/**
 * Telnet client API
 */
public class TelnetClient {

    /**
     * Create new socket connection to server
     * @param host server host name
     * @param port server port
     */
    public void connect(final String host, final int port) {
        System.out.println("Try to connect to server "+host + " on port "+port+".");
        try (final var socket = new Socket(host, port)) {
            System.out.println("Connected.");
            processSocket(socket);
        } catch (IOException e) {
            System.out.println("Server connection error.");
        }
    }

    /**
     * Process socket connection
     * @param socket socket connection
     */
    private void processSocket(final Socket socket) {
        try (final var out = new PrintWriter(socket.getOutputStream());
             final var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             final var stdIn = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("> ");
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                if (userInput.equals("q")) {
                    break;
                }
                out.print(userInput + "\r\n");
                out.flush();
                final var reply = in.readLine();
                if (reply == null) {
                    System.out.println("Server connection error.");
                    return;
                }
                System.out.println(reply);
                System.out.print("> ");
            }
        } catch (IOException e) {
            System.out.println("Data read/write error.");
        }
    }
}
