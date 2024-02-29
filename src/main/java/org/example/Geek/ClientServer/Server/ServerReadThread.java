package org.example.Geek.ClientServer.Server;

import java.io.*;
import java.net.Socket;

public class ServerReadThread extends Thread {

    private final Socket socket;
    private BufferedReader reader;
    private OutputStream outputStream;
    private PrintStream  printStream;

    public ServerReadThread(Socket socket) {
        this.socket = socket;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outputStream = socket.getOutputStream();
            printStream = new PrintStream(outputStream);
        } catch (IOException exception) {
            System.out.println("Exception: " + exception.getMessage());
        }
    }

    @Override
    public void run() {
        String message;
        try {
            while ((message = reader.readLine()) != null) {
                printStream.println("(" + socket.getPort() + ")" + message);
            }
        } catch (IOException exception) {
            System.out.println("Exception: " + exception.getMessage());
        }
    }
}
