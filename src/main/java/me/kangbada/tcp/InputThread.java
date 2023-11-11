package me.kangbada.tcp;

import java.io.BufferedReader;
import java.net.Socket;

public class InputThread extends Thread {
    private Socket sock;
    private BufferedReader clientInputStream;

    public InputThread(Socket sock, BufferedReader clientInputStream) {
        this.sock = sock;
        this.clientInputStream = clientInputStream;
    }

    @Override
    public void run() {
        try {
            String line;
            while ((line = clientInputStream.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (clientInputStream != null) {
                    clientInputStream.close();
                }
            } catch (Exception e) {}
            try {
                if (sock != null) {
                    sock.close();
                }
            } catch (Exception e) {}
        }
    }
}
