package me.kangbada.stream;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class SystemStream {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 5; i++) {
                PipedOutputStream readOut = new PipedOutputStream();
                PipedInputStream writeIn = new PipedInputStream(readOut);

                ReadThread rt = new ReadThread(System.in, readOut);
                ReadThread wt = new ReadThread(writeIn, System.out);

                rt.start();
                wt.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
