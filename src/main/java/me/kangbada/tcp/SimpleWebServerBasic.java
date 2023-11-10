package me.kangbada.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleWebServerBasic {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(80);
             Socket sock = serverSocket.accept();
             BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()))) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            System.out.println();
        }
    }
}
