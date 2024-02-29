package org.example.Geek.ClientServer.Client;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;

public class ClientVersion1 {

    private static final int PORT = 4305;

    public static void main(String[] args) {
        Socket clientSocket;
        try {
            InetAddress address = InetAddress.getLocalHost();
            clientSocket = new Socket(address, PORT);
            System.out.println(clientSocket.getInetAddress());
            System.out.println(clientSocket.getLocalPort());
            clientSocket.close();
        } catch (UnknownHostException  exception) {
            System.out.println("Exception: " + exception.getMessage());
        } catch (IOException exception) {
            System.out.println("Exception: " + exception.getMessage());
        }
    }
}
