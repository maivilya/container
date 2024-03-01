package org.example.Geek.ClientServer.EchoServer.Client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    private static final int PORT = 4305;

    public static void main(String[] args) {
        Socket clientSocket;
        try {
            InetAddress address = InetAddress.getLocalHost();
            clientSocket = new Socket(address, PORT);

            OutputStream outputStream = clientSocket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintStream printStream = new PrintStream(outputStream);

            String message;
            final Scanner scanner = new Scanner(System.in);
            while(!(message = scanner.nextLine()).equals("exit")) {
                printStream.println(message);
                System.out.println(reader.readLine());
            }

            scanner.close();
            clientSocket.close();
        } catch (UnknownHostException  exception) {
            System.out.println("Exception: " + exception.getMessage());
        } catch (IOException exception) {
            System.out.println("Exception: " + exception.getMessage());
        }
    }
}
