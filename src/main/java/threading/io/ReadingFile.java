package threading.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.*;

/**
 * Created by Pavitra on 11/22/2015.
 */
public class ReadingFile {
    public static void main(String[] args) {
        final int threadCount = 10;

        // BlockingQueue with a capacity of 200
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(200);

        // create thread pool with given size
        ExecutorService service = Executors.newFixedThreadPool(threadCount);

        for (int i = 0; i < (threadCount - 1); i++) {
            service.submit(new CPUTask(queue));
        }

        // Wait til FileTask completes
        try {
            service.submit(new FileTask(queue)).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        service.shutdownNow();  // interrupt CPUTasks

        // Wait til CPUTasks terminate
        try {
            service.awaitTermination(365, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class FileTask implements Runnable {

    private final BlockingQueue<String> queue;

    public FileTask(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("D:/abc.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                // block if the queue is full
                queue.put(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class CPUTask implements Runnable {

    private final BlockingQueue<String> queue;

    public CPUTask(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        String line;
        while (true) {
            try {
                // block if the queue is empty
                line = queue.take();
                // do things with line
            } catch (InterruptedException ex) {
                break; // FileTask has completed
            }
        }
        // poll() returns null if the queue is empty
        while ((line = queue.poll()) != null) {
            // do things with line;
        }
    }
}