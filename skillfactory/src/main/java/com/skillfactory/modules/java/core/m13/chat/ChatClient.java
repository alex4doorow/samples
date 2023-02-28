package com.skillfactory.modules.java.core.m13.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

class ChatClient implements Runnable {
    Socket socket;
    PrintStream out;
    ChatServer parent;

    public ChatClient(Socket socket, ChatServer parent) {
        this.socket = socket;
        this.parent = parent;
        new Thread(this).start();
    }

    public void run() {
        try {
            // получаем потоки ввода и вывода
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            // создаем удобные средства ввода и вывода
            Scanner in = new Scanner(is);
            out = new PrintStream(os);
            // читаем из сети и пишем в сеть
            out.println("Welcome to chat!");
            String input = in.nextLine();
            while (!input.equals("bye")) {
                parent.sendAll(input);
                input = in.nextLine();
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void receive(String message) {
        out.println(message);
    }
}
