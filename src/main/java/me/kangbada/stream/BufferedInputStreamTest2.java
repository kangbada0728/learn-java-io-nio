package me.kangbada.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedInputStreamTest2 {
    public static void main(String[] args) throws Exception {
        InputStream in = new FileInputStream("/Users/kangbada/pet.jpg");
        OutputStream out = new FileOutputStream("/Users/kangbada/pet2.jpg");
        BufferedInputStream bin = new BufferedInputStream(in);
        BufferedOutputStream bout = new BufferedOutputStream(out);

        int copyByte = 0;
        int bData;
        long stime = System.currentTimeMillis();
        while(true) {
            bData = bin.read();
            if(bData == -1)
                break;
            bout.write(bData);
            copyByte++;
        }
        long etime = System.currentTimeMillis();
        bin.close();
        bout.close();
        System.out.println("---------------버퍼 스트림 전송시간--------------------");
        System.out.println("복사 시간: "+(etime-stime));
        System.out.println("복사된 바이트의 크기: "+copyByte);


    }
}