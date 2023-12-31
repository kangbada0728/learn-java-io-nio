package me.kangbada.thread;

public class DeamonThreadTest {
    public static void main(String[] args) {
        // 스레드를 생성한다.
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    // 5초 간 멈춘다.
                    Thread.sleep(5000);
                    // 스레드 종료 메시지
                    System.out.println("MyThread 종료");
                } catch (Exception e) {
                    // 무시한다.
                }
            }
        };
        // 데몬 스레드로 설정한다.
        t.setDaemon(true);
        // 스레드를 시작한다.
        t.start();

        // main 메소드 종료 메시지
        System.out.println("main() 종료");
    }
}
