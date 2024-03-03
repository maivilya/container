package org.example.Geek.ClientServer.Chat.Client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

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

    public void listenMessage() {
        new Thread(() -> {
            try {
                String message;
                while(socket.isConnected()) {
                    message = reader.readLine();
                    System.out.println(message);
                }
            } catch (IOException exception) {
                closeResources(socket, reader, writer);
            }
        }).start();
    }

    public void sendMessage() {
        try{
            writer.write(name);
            writer.newLine();
            writer.flush();

            String message;
            Scanner scanner = new Scanner(System.in);
            while(socket.isConnected()) {
                message = scanner.nextLine();
                writer.write(name + ": " + message);
                writer.newLine();
                writer.flush();
            }
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

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            Socket socket = new Socket(InetAddress.getLocalHost(), 4304);
            Client client = new Client(socket, name);
            client.listenMessage();
            client.sendMessage();
        } catch (IOException exception) {
            System.out.println("Exception: " + exception.getMessage());
        }
    }
}
