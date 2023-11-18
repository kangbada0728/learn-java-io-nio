package me.kangbada.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UDPEchoClient {
    public static void main(String[] args) {
        String ip = "127.0.0.1";
        int port = 3000;

        InetAddress inetaddr;
        try {
            inetaddr = InetAddress.getByName(ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return;
        }

        try (DatagramSocket dsock = new DatagramSocket();
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String line;
            while ((line = br.readLine()) != null) {
                // 전송
                DatagramPacket sendPacket = new DatagramPacket(line.getBytes(), line.getBytes().length, inetaddr, port);
                dsock.send(sendPacket);

                if (line.equals("quit")) {
                    break;
                }

                // 받기
                byte[] buffer = new byte[line.getBytes().length];
                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
                dsock.receive(receivePacket);

                // 받은 결과를 출력한다.
                String msg = new String(receivePacket.getData(), 0, receivePacket.getData().length);
                System.out.println("전송받은 문자열 : " + msg);
            }
            System.out.println("UDPEchoClient 를 종료합니다.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
