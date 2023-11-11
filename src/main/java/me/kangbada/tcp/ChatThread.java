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
    private final Socket clientSocket;
    private String id;
    private BufferedReader clientBufferedReader;
    private final Map<String, PrintWriter> clientPrintWriters;
    private boolean initFlag = false;

    public ChatThread(Socket clientSocket, Map<String, PrintWriter> clientPrintWriters) {
        this.clientSocket = clientSocket;
        this.clientPrintWriters = clientPrintWriters;
        try {
            clientBufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            this.id = clientBufferedReader.readLine();

            broadcast(id + "님이 접속했습니다.");
            System.out.println("접속한 사용자의 아이디는 " + id + "입니다.");

            PrintWriter clientPrintWriter = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            clientPrintWriters.put(this.id, clientPrintWriter);
            initFlag = true;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void run() {
        try {
            String line;
            while ((line = clientBufferedReader.readLine()) != null) {
                if (line.startsWith("/quit")) { // /quit 으로 시작하면 종료한다.
                    break;
                }
                if (line.startsWith("/to ")) { // /to 로 시작하면 특정 클라이언트에게 메시지를 보낸다.
                    sendMsg(line);
                } else { // 전체 클라이언트에게 메시지를 보낸다.
                    broadcast(id + " : " + line);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            clientPrintWriters.remove(id); // Client 목록에서 제거한다.
            broadcast(id + " 님이 접속 종료했습니다.");
            try {
                if (clientSocket != null) {
                    clientSocket.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void broadcast(String msg) {
        for (PrintWriter pw : clientPrintWriters.values()) {
            pw.println(msg);
            pw.flush();
        }
    }

    private void sendMsg(String msg) {
        List<String> splits = Arrays.asList(msg.split(" ", 2)); // format : /to 전송할_클라이언트_ID message
        if (splits.size() != 3) {
            String to = splits.get(1);
            String realMsg = splits.get(2);

            PrintWriter pw = clientPrintWriters.get(to);
            if (pw != null) {
                pw.println(id + " 님이 다음의 귓속말을 보내셨습니다. : " + realMsg);
                pw.flush();
            }
        }
    }
}
