package me.kangbada.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        String clientId = args[0];
        String serverIp = "127.0.0.1";

        boolean endflag = false;

        try (Socket sock = new Socket(serverIp, 10001);
             PrintWriter clientOutputStream = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
             BufferedReader clientInputStream = new BufferedReader(new InputStreamReader(sock.getInputStream()));
             BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in))) {

            clientOutputStream.println(clientId);
            clientOutputStream.flush();

            InputThread it = new InputThread(sock, clientInputStream);
            it.start();

            String line;
            while ((line = keyboard.readLine()) != null) {
                clientOutputStream.println(line);
                clientOutputStream.flush();
                if (line.equals("/quit")) {
                    endflag = true;
                    break;
                }
            }
            System.out.println("클라이언트의 접속을 종료합니다.");

        } catch (Exception e) {
            if (!endflag) {
                System.out.println(e);
            }
        }
    }
}
