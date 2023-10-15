package me.kangbada.stream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileVew2 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("/Users/kangbada/test");
            int readcount = 0;
            byte[] buffer = new byte[512];
            while ((readcount = fis.read(buffer)) != -1) {
                System.out.write(buffer, 0, readcount);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
