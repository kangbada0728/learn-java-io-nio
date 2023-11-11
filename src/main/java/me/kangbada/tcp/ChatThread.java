package me.kangbada.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ChatThread extends Thread {
    private final Socket sock;
    private String id;
    private BufferedReader br;
    private final Map<String, PrintWriter> clientWriters;
    private boolean initFlag = false;

    public ChatThread(Socket sock, Map<String, PrintWriter> clientWriters) {
        this.sock = sock;
        this.clientWriters = clientWriters;
        try {
            br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            this.id = br.readLine();
            broadcast(id + "님이 접속했습니다.");
            System.out.println("접속한 사용자의 아이디는 " + id + "입니다.");

            PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
            synchronized (clientWriters) {
                clientWriters.put(this.id, pw);
            }
            initFlag = true;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void run() {
        try {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("/quit")) {
                    break;
                }
                if (line.startsWith("/to ")) {
                    sendMsg(line);
                } else {
                    broadcast(id + " : " + line);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            synchronized (clientWriters) {
                clientWriters.remove(id);
            }
            broadcast(id + " 님이 접속 종료했습니다.");
            try {
                if (sock != null) {
                    sock.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void broadcast(String msg) {
        synchronized (clientWriters) {
            for (PrintWriter pw : clientWriters.values()) {
                pw.println(msg);
                pw.flush();
            }
        }
    }

    private void sendMsg(String msg) {
        List<String> splits = Arrays.asList(msg.split(" ", 2)); // format : /to client_id message
        if (splits.size() != 3) {
            String to = splits.get(1);
            String realMsg = splits.get(2);

            PrintWriter pw = clientWriters.get(to);
            if (pw != null) {
                pw.println(id + " 님이 다음의 귓속말을 보내셨습니다. : " + realMsg);
                pw.flush();
            }
        }
    }
}
