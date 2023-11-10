package me.kangbada.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) {
        try {
            Socket sock = new Socket("127.0.0.1", 10001);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));

            String line;
            while ((line = keyboard.readLine()) != null) {
                if (line.equals("quit")) {
                    break;
                }
                pw.println(line);
                pw.flush();

                String echo = br.readLine();
                System.out.println("서버로부터 전달받은 문자열 : " + echo);
            }

            pw.close();
            br.close();
            sock.close();

        } catch (Exception e) {
            System.out.println("연결종료");
        }
    }
}
