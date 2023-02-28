package com.skillfactory.modules.java.core.m13.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    final private List<ChatClient> clients = new ArrayList<>();
    final private ServerSocket serverSocket;

    public ChatServer() throws IOException {
        // создаем серверный сокет на порту 1234
        serverSocket = new ServerSocket(1234);
    }

    public void sendAll(String message) {
        clients.forEach(c -> c.receive(message));
    }

    public void run() throws IOException {
        while (true) {
            System.out.println("Waiting...");
            // ждем клиента из сети
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");
            // создаем клиента на своей стороне
            clients.add(new ChatClient(socket, this));
        }
    }

    public static void main(String[] args) throws IOException {
        ChatServer chatServer = new ChatServer();
        chatServer.run();
    }
}
