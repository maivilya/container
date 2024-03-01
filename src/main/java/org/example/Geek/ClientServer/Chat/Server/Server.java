package org.example.Geek.ClientServer.Chat.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void runServer() {
        try {
            while (!serverSocket.isClosed()) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted new client");
                //TODO: Client
            }
        } catch (IOException exception) {
            //TODO: сделать метод закрытия ресурсов
        }
    }
}
