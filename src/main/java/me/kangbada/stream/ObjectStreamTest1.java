package me.kangbada.stream;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class ObjectStreamTest1 {
    public static void main(String[] args) {
        Vector v = new Vector();
        Vector v1 = new Vector();
        Vector v2 = new Vector();
        Vector v3 = new Vector();
        v1.add("data 1");
        v1.add("data 2");
        v1.add("data 3");
        v2.add("data 4");
        v3.add(v2);
        v.add(v1);
        v.add(v3);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/Users/kangbada/object.dat"))) {
            oos.writeObject(v);
            oos.reset();
            System.out.println("저장되었습니다.");
        } catch (Exception e) {}

    }
}
