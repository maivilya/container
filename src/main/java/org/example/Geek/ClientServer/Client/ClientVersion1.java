package org.example.Geek.ClientServer.Client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientVersion1 {

    private static final int PORT = 4305;

    public static void main(String[] args) {
        Socket clientSocket;
        try {
            InetAddress address = InetAddress.getLocalHost();
            clientSocket = new Socket(address, PORT);

            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            PrintStream printStream = new PrintStream(outputStream);

            printStream.println("pop");
            System.out.println(dataInputStream.readLine());

            clientSocket.close();
        } catch (UnknownHostException  exception) {
            System.out.println("Exception: " + exception.getMessage());
        } catch (IOException exception) {
            System.out.println("Exception: " + exception.getMessage());
        }
    }
}
