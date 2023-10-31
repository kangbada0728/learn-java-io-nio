package me.kangbada.network;

import java.net.InetAddress;

public class NSLookup {
    public static void main(String[] args) {
        InetAddress inetaddr[] = null;
        try {
            inetaddr = InetAddress.getAllByName("www.google.com");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        for (int i = 0; i < inetaddr.length; i++) {
            System.out.println(inetaddr[i].getHostName());
            System.out.println(inetaddr[i].getHostAddress());
            System.out.println(inetaddr[i].toString());
            System.out.println();
        }
    }
}
