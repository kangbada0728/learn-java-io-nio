package me.kangbada.tcp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class HttpThread extends Thread {
    private Socket sock;

    public HttpThread(Socket sock) {
        this.sock = sock;
    }

    @Override
    public void run() {
        String filename = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()))) {

            String line = br.readLine();
            int start = line.indexOf(" ") + 2;
            int end = line.lastIndexOf("HTTP") - 1;

            filename = line.substring(start, end);
            if (filename.equals("")) {
                filename = "index.html";
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try (BufferedReader fbr = new BufferedReader(new FileReader(filename));
             PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()))) {

            System.out.println("사용자가 " + filename + "을 요청했습니다.");
            String fline;
            while ((fline = fbr.readLine()) != null) {
                pw.println(fline);
                pw.flush();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
