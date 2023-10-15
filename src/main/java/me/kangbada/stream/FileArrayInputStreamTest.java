package me.kangbada.stream;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;

public class FileArrayInputStreamTest {
    public static void main(String[] args) {
        String arg = "";
        if (arg.equals("file")) {
            try (FileInputStream fis = new FileInputStream("/Users/kangbada/test")) {
                int readcount = 0;
                byte[] buffer = new byte[512];
                while ((readcount = fis.read(buffer)) != -1) {
                    System.out.write(buffer, 0, readcount);
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if(arg.equals("array")) {
            byte[] abc = new byte[26];
            for (int i = 0; i < 26; i++) {
                abc[i] = (byte) ('a' + i);
            }

            try (ByteArrayInputStream bais = new ByteArrayInputStream(abc)) {
                int readcount = 0;
                byte[] buffer = new byte[512];
                while ((readcount = bais.read(buffer)) != -1) {
                    System.out.write(buffer, 0, readcount);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
