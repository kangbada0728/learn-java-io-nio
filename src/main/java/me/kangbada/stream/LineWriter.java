package me.kangbada.stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class LineWriter {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/kangbada/test")), true)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("읽어들인 문자열 : " + line);
                pw.println(line);
            }

        } catch (Exception e) {

        }
    }
}
