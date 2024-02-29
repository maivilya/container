package org.example.Geek.ClientServer.Client;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;

public class ClientVersion1 {

    public static void main(String[] args) {
        Socket clietnSocket;
        try {
            InetAddress address = InetAddress.getLocalHost();
            clietnSocket = new Socket(address, 4305);
            System.out.println(clietnSocket.getInetAddress());
            clietnSocket.close();
        } catch (UnknownHostException  exception) {
            System.out.println("Exception: " + exception.getMessage());
        } catch (IOException exception) {
            System.out.println("Exception: " + exception.getMessage());
        }
    }
}
