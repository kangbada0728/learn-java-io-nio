package me.kangbada.thread;

public class StopThreadTest {
    public static void main(String[] args) {
        System.out.println("# Start StopThreadTest.java");
        StopThreadTest stt = new StopThreadTest();
        stt.process();
    }

    public void process() {
        StopThread st = new StopThread();
        Thread thread = new Thread(st);
        thread.start();
        try {
            // 1초 간 멈춘다.
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // StopThread 를 정지시킨다.
        st.stop();
    }

    static class StopThread implements Runnable {
        // 조건문을 빠져나가기 위해 사용할 플래그 변수다.
        private boolean stopped = false;

        public void run() {
            // stopped 플래그를 while문 조건으로 사용한다.
            while (!stopped) {
                System.out.println("Thread is alive..");
                try {
                    // 0.5초간 멈춘다.
                    // 이 곳에서 sleep 메소드를 호출하는 이유는 while 같은 반복문을
                    // 조금의 여유도 없이 수행하면 CPU 에 많은 부담을 주기 때문이다.
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread is dead..");
        }

        // 이 메소드 호출로 StopThread 가 멈춘다.
        public void stop() {
            stopped = true;
        }
    }
}
