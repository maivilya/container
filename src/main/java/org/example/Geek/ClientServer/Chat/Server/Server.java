package org.example.Geek.ClientServer.Chat.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    /**
     * Порт, на котором мы будем слушать пользователей
     */
    private static final int PORT = 4304;
    private final ServerSocket serverSocket;

    /**
     * Базовый конструктор создания нашего сервера
     * @param serverSocket сокет, на основе которого будет создаваться сервер
     */
    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    /**
     * Метод ожидает запросы на подключения и если подключение удалось
     * создает новых пользователей(сокеты) и запускаем их в отдельном новом потоке
     */
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
    /**
     * Метод, закрывающий ресурсы сервера. В данном случае это только сокет
     */
    private void closeResources() {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException exception) {
                System.out.println("Exception: " + exception);
            }
        }
    }

    /**
     * Метод запускает работу сервера
     * @param args входные параметры нашего приложения
     */
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
