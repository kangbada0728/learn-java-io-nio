package me.kangbada.tcp;

import java.io.BufferedReader;
import java.net.Socket;

public class InputThread extends Thread {
    private Socket sock;
    private BufferedReader serverInputStream;

    public InputThread(Socket sock, BufferedReader serverInputStream) {
        this.sock = sock;
        this.serverInputStream = serverInputStream;
    }

    @Override
    public void run() {
        try {
            String line;
            while ((line = serverInputStream.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (serverInputStream != null) {
                    serverInputStream.close();
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
