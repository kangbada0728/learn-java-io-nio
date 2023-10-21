package me.kangbada.stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferFileCopy {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("/Users/kangbada/test");
             BufferedReader br = new BufferedReader(fr);
             FileWriter fw = new FileWriter("/Users/kangbada/test2");
             BufferedWriter bw = new BufferedWriter(fw)) {

            char[] buffer = new char[512];
            int readcount = 0;
            while ((readcount = br.read(buffer)) != -1) {
                bw.write(buffer, 0, readcount);
            }
            bw.flush();

        } catch (Exception e) {

        }
    }
}
