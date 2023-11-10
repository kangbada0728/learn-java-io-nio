package me.kangbada.tcp;

import java.net.ServerSocket;
import java.net.Socket;

public class EchoThreadServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(10001)) {
            System.out.println("접속을 기다립니다.");

            while (true) {
                Socket sock = server.accept();
                EchoThread echoThread = new EchoThread(sock);
                echoThread.start();
            }

        } catch (Exception e) {}
    }
}
