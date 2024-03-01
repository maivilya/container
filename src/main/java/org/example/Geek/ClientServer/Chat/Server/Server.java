package org.example.Geek.ClientServer.Chat.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final ServerSocket serverSocket;
    private static final int PORT = 4304;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void runServer() {
        try {
            while (!serverSocket.isClosed()) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted new client");
                ClientManager client = new ClientManager(clientSocket);
                Thread thread = new Thread(client);
                thread.start();
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
                System.out.println("Exception: " + exception);
            }
        }
    }

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            Server server = new Server(serverSocket);
            server.runServer();
        } catch (IOException exception) {
            System.out.println("Exception: " + exception);
        }
    }
}
