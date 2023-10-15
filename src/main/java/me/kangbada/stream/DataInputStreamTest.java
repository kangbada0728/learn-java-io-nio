package me.kangbada.stream;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataInputStreamTest {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("/Users/kangbada/test");
             DataInputStream dis = new DataInputStream(fis)) {
            boolean b = dis.readBoolean();
            System.out.println("boolean = " + b);

            byte b2 = dis.readByte();
            System.out.println("byte = " + b2);

            int i = dis.readInt();
            System.out.println("int = " + i);

            double d = dis.readDouble();
            System.out.println("double = " + d);

            String s = dis.readUTF();
            System.out.println("String = " + s);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
