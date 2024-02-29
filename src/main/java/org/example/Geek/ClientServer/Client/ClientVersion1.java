package org.example.Geek.ClientServer.Client;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ClientVersion1 {

    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(address);
        } catch (UnknownHostException exception) {
            System.out.println("Exception: " + exception.getMessage());
        }
    }
}
