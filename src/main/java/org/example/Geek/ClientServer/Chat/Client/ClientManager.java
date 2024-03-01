package org.example.Geek.ClientServer.Chat.Client;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientManager {

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
            //TODO: метод, который разошлет всем информацию о новое подключенном пользователе
        } catch (IOException exception) {
            //TODO:Метод закрития ресурсов
        }
    }
}