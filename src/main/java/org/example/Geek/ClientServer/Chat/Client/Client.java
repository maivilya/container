package org.example.Geek.ClientServer.Chat.Client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.Socket;

public class Client {

    private final Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private final String name;

    public Client(Socket socket, String name) {
        this.socket = socket;
        this.name = name;
    }
}
