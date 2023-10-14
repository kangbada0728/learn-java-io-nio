package me.kangbada.file;

import java.io.File;
import java.io.IOException;

public class TempFile {
    public static void main(String[] args) {
        try {
            File f = File.createTempFile("tmp_", ".dat");
            System.out.println(f.getAbsolutePath());
            System.out.println("6초 동안 멈춰있습니다.");
            try {
                Thread.sleep(6000); // 6초 동안 프로그램이 멈춰 있는다.
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            f.deleteOnExit(); // JVM 이 종료될 때 임시 파일을 자동으로 삭제한다.
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
