package me.kangbada.thread;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class JobQueue implements Queue {
    private static final String NAME = "JOB QUEUE";
    private static final Object monitor = new Object();

    private LinkedList<String> jobs = new LinkedList<>();

    // ------------------------------------------ //
    // 하나의 객체만을 생성해서 사용할 수 있도록 싱글톤 패턴을 사용한다.
    private static JobQueue instance = new JobQueue();
    private JobQueue() {}

    public static JobQueue getInstance() {
        if (instance == null) {
            synchronized (JobQueue.class) {
                instance = new JobQueue();
            }
        }
        return instance;
    }
    // ------------------------------------------ //


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void clear() {
        synchronized (monitor) {
            jobs.clear();
        }
    }

    @Override
    public void put(String str) {
        synchronized (monitor) {
            jobs.addLast(str);
            // 새로운 데이터가 추가되어 큐가 이용할 수 있으므로
            // 만약, 대기중인 스레드가 있다면 깨운다.
            monitor.notify();
        }
    }

    @Override
    public String pop() throws InterruptedException, NoSuchElementException {
        String str;
        synchronized (monitor) {
            // 더 이상 큐에서 이용할 수 있는 데이터가 없으므로 스레드를 대기시킨다.
            if (jobs.isEmpty()) {
                monitor.wait();
            }
            str = jobs.removeFirst();
        }
        if (str == null) {
            throw new NoSuchElementException();
        }
        return str;
    }

    @Override
    public int size() {
        return jobs.size();
    }
}
