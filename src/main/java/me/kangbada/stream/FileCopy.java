package me.kangbada.stream;

import java.io.FileReader;
import java.io.FileWriter;

public class FileCopy {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("/Users/kangbada/test");
             FileWriter fw = new FileWriter("/Users/kangbada/test2")) {

            char[] buffer = new char[512];
            int readcount = 0;
            while ((readcount = fr.read(buffer)) != -1) {
                fw.write(buffer, 0, readcount);
            }

        } catch (Exception e) {

        }
    }
}
