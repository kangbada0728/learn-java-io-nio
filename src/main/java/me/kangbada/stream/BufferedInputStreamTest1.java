package me.kangbada.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedInputStreamTest1 {
    public static void main(String[] args) throws Exception {
        InputStream in = new FileInputStream("/Users/kangbada/pet.jpg");
        OutputStream out = new FileOutputStream("/Users/kangbada/pet2.jpg");
        int copyByte = 0;
        int data;
        long stime = System.currentTimeMillis();
        byte[] buffer = new byte[512];
        while(true) {
            data = in.read(buffer);
            if(data==-1)
                break;
            out.write(buffer, 0, data);
            copyByte++;
        }
        long etime = System.currentTimeMillis();
        in.close();
        out.close();
        System.out.println("복사 시간: "+(etime-stime));
        System.out.println("복사된 배열의 크기: "+copyByte);


    }
}