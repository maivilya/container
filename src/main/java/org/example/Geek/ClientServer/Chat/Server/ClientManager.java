package org.example.Geek.ClientServer.Chat.Server;

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

    /**
     * Метод рассылает сообщения всем пользователям от другого пользователя
     */
    @Override
    public void run() {
        String message;
        while(socket.isConnected()) {
            try {
                message = reader.readLine();
                broadcastMessage(message);
            } catch (IOException exception) {
                closeResources(socket, reader, writer);
                break;
            }
        }
    }

    /**
     * Метод отправки сообщения всем пользователям
     * @param message сообщение, которое нужно отправить
     */
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

    /**
     * Метод, закрывающий все ресурсы
     * @param socket сокет, который требуется закрыть
     * @param reader буферизированный поток чтения, который нужно закрыть
     * @param writer буферизированный поток записи, который нужно закрыть
     */
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
