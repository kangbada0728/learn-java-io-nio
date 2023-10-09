package me.kangbada.thread;

import java.util.NoSuchElementException;

public interface Queue {
    String getName();
    void clear();
    void put(String str);
    String pop() throws InterruptedException, NoSuchElementException;
    int size();
}
