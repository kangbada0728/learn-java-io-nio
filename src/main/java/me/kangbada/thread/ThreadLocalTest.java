package me.kangbada.thread;

import java.util.Random;

public class ThreadLocalTest {
    // 카운터 변수를 생성한다.
    static volatile int counter = 0;
    static Random random = new Random();

    // ThreadLocal 을 상속한 ThreadLocalObject 클래스를 생성한다.
    private static class ThreadLocalObject extends ThreadLocal<Integer> {
        Random random = new Random();

        @Override
        protected Integer initialValue() {
            return random.nextInt(1000);
        }
    }

    // ThreadLocal 의 변수를 생성하나.
    static ThreadLocal<Integer> threadLocal = new ThreadLocalObject();

    // 각 스레드의 value 출력 메소드
    private static void displayValues() {
        System.out.println("Thread Name:" + Thread.currentThread().getName()
                + ", initialValue:" + threadLocal.get()
                + ", counter:" + counter);
    }

    public static void main(String[] args) {
        displayValues();

        Runnable runner = new Runnable() {
            @Override
            public void run() {
                synchronized (ThreadLocalTest.class) {
                    counter++;
                }
                displayValues();
                try {
                    Thread.sleep(threadLocal.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(runner);
            t.start();
        }
    }
}
