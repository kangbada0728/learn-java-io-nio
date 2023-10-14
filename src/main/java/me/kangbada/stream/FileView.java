package me.kangbada.stream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileView {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("/Users/kangbada/test");
            int i = 0;
            while ((i = fis.read()) != -1) {
                System.out.write(i);
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
