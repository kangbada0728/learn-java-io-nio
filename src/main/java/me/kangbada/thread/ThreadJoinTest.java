package me.kangbada.thread;

public class ThreadJoinTest {
    public static void main(String[] args) {
        // 스레드를 생성한다.
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    // 2초 간 멈춘다.
                    Thread.sleep(2000);
                    // 스레드 종료 메시지
                    System.out.println("MyThread 종료");
                    // 3초 간 멈춘다.
                    Thread.sleep(3000);
                } catch (Exception e) {
                    // 무시한다.
                }
            }
        };
        // 스레드를 시작한다.
        t.start();
        try {
            // join() 메소드를 실행한다.
            // t 스레드가 종료될 때까지 main 스레드가 기다린다.
            // join() 메소드가 InterruptedException 을 발생시키는 것에 주의한다.
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // main 메소드 종료 메시지
        System.out.println("main() 종료");
    }
}
