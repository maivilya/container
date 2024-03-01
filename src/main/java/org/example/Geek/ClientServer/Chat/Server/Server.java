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
            closeResources();
        }
    }

    private void closeResources() {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException exception) {
                System.out.println("Exception: " + exception.getMessage());
            }
        }
    }
}
