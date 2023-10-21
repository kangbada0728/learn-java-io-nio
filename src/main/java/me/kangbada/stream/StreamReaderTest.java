package me.kangbada.stream;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StreamReaderTest {
    public static void main(String[] args) {

        try (InputStreamReader isr = new InputStreamReader(new FileInputStream("/Users/kangbada/test"));
             OutputStreamWriter osw = new OutputStreamWriter(System.out)) {

            char[] buffer = new char[512];
            int readcount = 0;
            while ((readcount = isr.read(buffer)) != -1) {
                osw.write(buffer, 0, readcount);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
