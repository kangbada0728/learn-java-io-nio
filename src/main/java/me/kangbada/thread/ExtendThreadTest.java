package me.kangbada.thread;

public class ExtendThreadTest {
    public static void main(String[] args) {
        Thread t = new ExtendThread();
        // start()를 이용해서 스레드를 시작시킨다.
        // 이후 ExtendThread 의 run() 이 실행되고
        // run() 이 종료되면 바로 ExtendThread 가 소멸된다.
        t.start();
    }

    static class ExtendThread extends Thread {
        // run() 을 오버라이딩해서 재정의한다.
        public void run() {
            System.out.println("Thread 클래스를 상속");
        }
    }
}
