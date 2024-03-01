package org.example.Geek.ClientServer.Chat.Client;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientManager implements Runnable{

    private final Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private String name;
    public static List<ClientManager> clients = new ArrayList<>();

    public ClientManager(Socket socket) {
        this.socket = socket;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            name = reader.readLine();
            clients.add(this);
            broadcastMessage("Server(" + socket.getPort() + "): подключился новый пользователь " + name);
        } catch (IOException exception) {
            closeResources(socket, reader, writer);
        }
    }

    @Override
    public void run() {

    }

    private void broadcastMessage(String message) {
        for (ClientManager client : clients) {
            if (!client.name.equals(name)) {
                try {
                    client.writer.write(message);
                    client.writer.newLine();
                    client.writer.flush();
                } catch (IOException exception) {
                    closeResources(socket, reader, writer);
                }
            }
        }
    }

    private void closeResources(Socket socket, BufferedReader reader, BufferedWriter writer) {
        clients.remove(this);
        broadcastMessage("Server(" + socket.getPort() + "): пользователь " + name + " отключился");
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
