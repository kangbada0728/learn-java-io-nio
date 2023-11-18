package me.kangbada.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEchoServer {
    public static void main(String[] args) {
        int port = 3000;
        System.out.println("접속 대기상태입니다.");
        try (DatagramSocket dsock = new DatagramSocket(port)) {
            String line;
            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
                dsock.receive(receivePacket);

                String msg = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("전송 받은 문자열 : " + msg);
                if (msg.equals("quit")) {
                    break;
                }

                DatagramPacket sendPacket = new DatagramPacket(
                        receivePacket.getData(),
                        receivePacket.getData().length,
                        receivePacket.getAddress(),
                        receivePacket.getPort());
                dsock.send(sendPacket);
            }
            System.out.println("UDPEchoServer 를 종료합니다.");

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
