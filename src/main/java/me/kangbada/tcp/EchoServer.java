package me.kangbada.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(10001);
            System.out.println("접속을 기다립니다.");
            Socket sock = server.accept();

            InetAddress inetAddress = sock.getInetAddress();
            System.out.println(inetAddress.getHostAddress() + " 로부터 접속했습니다.");

            BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("클라이언트로 부터 전송받은 문자열 : " + line);
                pw.println(line);
                pw.flush();
            }

            br.close();
            pw.close();
            sock.close();

        } catch (Exception e) {
            System.out.println("연결종료");
        }
    }
}
