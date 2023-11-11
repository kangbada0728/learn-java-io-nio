package me.kangbada.tcp;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ChatServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(10001)) {
            System.out.println("접속을 기다립니다.");
            HashMap<String, PrintWriter> clientWriters = new HashMap<>();
            while (true) {
                Socket sock = server.accept();
                ChatThread chatThread = new ChatThread(sock, clientWriters);
                chatThread.start();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
