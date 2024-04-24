package sysdesign.filedownloader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class DownloadDispatcher {

    private final BlockingQueue<DownloadJob> jobQueue;
    private final ExecutorService workerPool;
    private final Map<String, DownloadJob> activeJobs; // Map request URL to DownloadJob for faster lookup
    private final int maxThreads;

    public DownloadDispatcher(int maxParallelDownloads) {
        this.jobQueue = new LinkedBlockingQueue<>();
        this.workerPool = Executors.newFixedThreadPool(maxParallelDownloads);
        this.activeJobs = new ConcurrentHashMap<>();
        this.maxThreads = maxParallelDownloads;
        startWorkers();
    }

    public FileDownloadTask enqueue(FileDownloadRequest request) {
        DownloadJob job = new DownloadJob(request);
        activeJobs.put(request.getSourceUrl(), job);
        jobQueue.offer(job);
        return new FileDownloadTask(request);
    }

    public void pauseAll() {
        // Implement logic to pause all active jobs (update states and potentially interrupt workers)
    }

    public void resumeAll() {
        // Implement logic to resume all paused jobs (update states and potentially notify workers)
    }

    public void cancelAll() {
        // Implement logic to cancel all jobs (remove from queue, update states, interrupt workers)
    }

    public List<FileDownloadTask> getActiveTasks() {
        List<FileDownloadTask> activeTasks = new ArrayList<>();
        for (DownloadJob job : activeJobs.values()) {
            if (job.getState() == DownloadJob.State.ACTIVE) {
                activeTasks.add(new FileDownloadTask(job.getRequest()));
            }
        }
        return activeTasks;
    }

    private void startWorkers() {
        for (int i = 0; i < maxThreads; i++) {
            workerPool.submit(() -> {
                while (!Thread.interrupted()) {
                    try {
                        DownloadJob job = jobQueue.take();
                        // Download logic using job.getRequest()
                        // Update job state based on download success or failure
                        activeJobs.remove(job.getRequest().getSourceUrl());
                        // Notify download callbacks (success/failure)
                    } catch (InterruptedException e) {
                        // handle interruption
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }
    }

    private static class DownloadJob {

        enum State {PENDING, ACTIVE, PAUSED, COMPLETED, FAILED}

        private final FileDownloadRequest request;
        private State state;

        public DownloadJob(FileDownloadRequest request) {
            this.request = request;
            this.state = State.PENDING;
        }

        public FileDownloadRequest getRequest() {
            return request;
        }

        public State getState() {
            return state;
        }

        // Getter methods for request and state
    }
}
