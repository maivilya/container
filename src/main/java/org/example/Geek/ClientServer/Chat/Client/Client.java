package org.example.Geek.ClientServer.Chat.Client;

import java.io.*;
import java.net.Socket;

public class Client {

    private final Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private final String name;

    public Client(Socket socket, String name) {
        this.socket = socket;
        this.name = name;
        try {
          reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException exception) {
            closeResources(socket, reader, writer);
        }
    }

    private void closeResources(Socket socket, BufferedReader reader, BufferedWriter writer) {
        try {
            if (writer != null) {
                writer.close();
            }
            if (reader != null) {
                reader.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException exception) {
            System.out.println("Exception: " + exception.getMessage());
        }
    }
}
