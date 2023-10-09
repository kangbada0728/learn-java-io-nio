package me.kangbada.thread;

public class Consumer implements Runnable {
    private Queue queue;
    private String name;

    public Consumer(Queue queue, String index) {
        this.queue = queue;
        this.name = "Consumer~" + index;
    }

    @Override
    public void run() {
        System.out.println("[ Start " + name + ".. ]");
        try {
            while (!Thread.currentThread().isInterrupted()) {
                String pop = queue.pop();
                System.out.println(name + " : " + pop);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("[ End " + name + ".. ]");
        }
    }
}
