package me.kangbada.stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

public class ByteArrayInputOutputTest {
    public static void main(String[] args) {
        byte[] fileArray = null;
        try (FileInputStream fis = new FileInputStream("/Users/kangbada/test");
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            int readcount = 0;
            byte[] buffer = new byte[512];
            while ((readcount = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, readcount);
            }
            fileArray = baos.toByteArray();

        } catch (Exception e) {
            System.out.println(e);
        }

        try (ByteArrayInputStream bais = new ByteArrayInputStream(fileArray)) {
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
