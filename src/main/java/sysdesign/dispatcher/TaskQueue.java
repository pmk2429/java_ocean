package sysdesign.dispatcher;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TaskQueue {

    private final BlockingQueue<String> tasks;

    public TaskQueue() {
        // Create a LinkedBlockingQueue with a capacity of 10 elements
        this.tasks = new LinkedBlockingQueue<>(10);
    }

    public void addTask(String task) throws InterruptedException {
        // Add a task to the queue. The thread might block if the queue is full.
        tasks.put(task);
    }

    public String getTask() throws InterruptedException {
        // Get a task from the queue. The thread might block if the queue is empty.
        return tasks.take();
    }

    public static void main(String[] args) throws InterruptedException {
        TaskQueue queue = new TaskQueue();
        // Producer thread adding tasks to the queue
        new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                try {
                    queue.addTask("Task " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // Consumer thread getting tasks from the queue
        new Thread(() -> {
            while (true) {
                try {
                    String task = queue.getTask();
                    System.out.println("Processing task: " + task);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
