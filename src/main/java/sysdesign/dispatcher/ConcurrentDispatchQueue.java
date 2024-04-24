package sysdesign.dispatcher;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Showcases Message Queue like structure. This is how DispatchQueue operates when
 * adding or removing Jobs to the Queue.
 */
public class ConcurrentDispatchQueue {

    private final BlockingQueue<Runnable> queue;
    private final Thread[] threads;
    private volatile boolean running = true;

    public ConcurrentDispatchQueue(int numThreads) {
        queue = new LinkedBlockingQueue<>();
        threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new WorkerThread();
            threads[i].start();
        }
    }

    public boolean addJob(Runnable job) {
        return queue.add(job);
    }

    public boolean removeJob(Runnable job) {
        return queue.remove(job);
    }

    public void stop() {
        running = false;
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

    private class WorkerThread extends Thread {
        @Override
        public void run() {
            while (running) {
                try {
                    Runnable job = queue.take();
                    job.run();
                } catch (InterruptedException e) {
                    // Ignore interruption
                }
            }
        }
    }

    public static void main(String[] args) {
        ConcurrentDispatchQueue dispatchQueue = new ConcurrentDispatchQueue(4);
        for (int i = 0; i < 10; i++) {
            final int jobNumber = i;
            dispatchQueue.addJob(() -> {
                System.out.println("Running job " + jobNumber);
                try {
                    Thread.sleep(1000); // Simulate some work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Wait for jobs to complete
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Stop the dispatch queue
        dispatchQueue.stop();
    }
}
