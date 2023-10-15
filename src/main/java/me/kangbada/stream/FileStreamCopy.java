package me.kangbada.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamCopy {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream("/Users/kangbada/test");
            fos = new FileOutputStream("/Users/kangbada/test_copy");

            byte[] buffer = new byte[512];
            int readcount = 0;
            while ((readcount = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, readcount);
            }
            System.out.println("복사가 완료되었습니다.");
        } catch (Exception e) {
            System.out.println(e);
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }
    }
}
