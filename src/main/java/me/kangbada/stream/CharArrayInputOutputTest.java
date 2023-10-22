package me.kangbada.stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class CharArrayInputOutputTest {
    public static void main(String[] args) {
        char[] fileArray = new char[512];

        try (BufferedReader br = new BufferedReader(new FileReader("/Users/kangbada/test"));
             CharArrayWriter caw = new CharArrayWriter()) {

            char[] buffer = new char[512];
            int readcount = 0;
            while ((readcount = br.read(buffer)) != -1) {
                caw.write(buffer, 0, readcount);
            }
            fileArray = caw.toCharArray();

        } catch (Exception e) {}

        System.out.println("파일의 내용을 모두 읽어들여 Char[] 로 만들었다.");
        System.out.println("읽어들인 Char 의 수 : " + fileArray.length);

        try (CharArrayReader car = new CharArrayReader(fileArray);
             PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)), true)) {

            int readcount = 0;
            char[] buffer = new char[512];
            while ((readcount = car.read(buffer)) != -1) {
                pw.write(buffer, 0, readcount);
            }

        } catch (Exception e) {}
    }
}
