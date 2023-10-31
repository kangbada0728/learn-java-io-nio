package me.kangbada.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookupLocal {
    public static void main(String[] args) {
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return;
        }

        System.out.println(inetAddress.getHostName()); // 호스트 주소
        System.out.println(inetAddress.getHostAddress()); // IP 주소

        System.out.println("byte[] 형식의 ip 주소 값의 출력");
        byte[] ip = inetAddress.getAddress();
        for (int i = 0; i < ip.length; i++) {
            System.out.println(Byte.toUnsignedInt(ip[i]));
            if (i != ip.length - 1) {
                System.out.print(".");
            }
        }
    }
}
