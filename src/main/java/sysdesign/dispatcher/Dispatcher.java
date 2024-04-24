package sysdesign.dispatcher;

import java.util.ArrayDeque;
import java.util.Queue;

class DispatchQueue<T> {
    private final Queue<T> queue = new ArrayDeque<>();

    public synchronized void addTask(T task) {
        queue.offer(task);
        notify(); // Notify waiting consumer thread
    }

    public synchronized T getNextTask() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // Wait for producer to add tasks
        }
        return queue.poll();
    }
}

class Producer implements Runnable {
    private final DispatchQueue<Integer> dispatchQueue;

    public Producer(DispatchQueue<Integer> dispatchQueue) {
        this.dispatchQueue = dispatchQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            dispatchQueue.addTask(i);
            System.out.println("Produced: " + i);
            try {
                Thread.sleep(1000); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private final DispatchQueue<Integer> dispatchQueue;

    public Consumer(DispatchQueue<Integer> dispatchQueue) {
        this.dispatchQueue = dispatchQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer task = dispatchQueue.getNextTask();
                System.out.println("Consumed: " + task);
                // Process the task here
                Thread.sleep(2000); // Simulate processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Dispatcher {
    public static void main(String[] args) {
        DispatchQueue<Integer> dispatchQueue = new DispatchQueue<>();
        Thread producerThread = new Thread(new Producer(dispatchQueue));
        Thread consumerThread = new Thread(new Consumer(dispatchQueue));

        producerThread.start();
        consumerThread.start();
    }
}
