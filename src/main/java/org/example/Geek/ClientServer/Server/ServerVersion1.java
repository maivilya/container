package org.example.Geek.ClientServer.Server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.UnknownHostException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerVersion1 {

    private static final int PORT = 4305;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is started");
            Socket clientSocket = serverSocket.accept();

            OutputStream outputStream = clientSocket.getOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            printStream.println("Hello, client!");

            serverSocket.close();
            clientSocket.close();
        } catch (UnknownHostException exception) {
            System.out.println("Exception: " + exception.getMessage());
        } catch (IOException exception) {
            System.out.println("Exception: " + exception.getMessage());
        }
    }
}
