package com.skillfactory.modules.java.core.m13.t332;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerWithThreads {

    public static void main(String[] args) throws IOException {
        // создаем серверный сокет на порту 1234
        ServerSocket server = new ServerSocket(1234);
        while(true) {
            System.out.println("Waiting...");
            // ждем клиента из сети
            Socket socket = server.accept();
            System.out.println("Client connected!");
            // создаем клиента на своей стороне
            new Thread(new EchoClient(socket)).start();
        }
    }
}
