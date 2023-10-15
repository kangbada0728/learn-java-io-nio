package me.kangbada.stream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOutputStreamTest {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("/Users/kangbada/test");
             DataOutputStream dos = new DataOutputStream(fos)) {
            dos.writeBoolean(true);
            dos.writeByte((byte) 5);
            dos.writeInt(100);
            dos.writeDouble(200.5);
            dos.writeUTF("hello world");
            System.out.println("저장했습니다.");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
