package me.kangbada.stream;

import java.io.InputStream;
import java.io.OutputStream;

public class ReadThread extends Thread {
    private InputStream pi;
    private OutputStream po;

    public ReadThread(InputStream pi, OutputStream po) {
        this.pi = pi;
        this.po = po;
    }

    @Override
    public void run() {
        byte[] buffer = new byte[512];
        int bytes_read = 0;
        try {
            while ((bytes_read = pi.read(buffer)) != -1) {
                po.write(buffer, 0, bytes_read);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
