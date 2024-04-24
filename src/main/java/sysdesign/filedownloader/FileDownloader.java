package sysdesign.filedownloader;

import java.util.List;

public class FileDownloader {

    private final DownloadDispatcher dispatcher;
    private final int maxParallelDownloads;

    public FileDownloader(FileDownloaderConfig config) {
        this.maxParallelDownloads = config.getMaxParallelDownloads();
        this.dispatcher = new DownloadDispatcher(maxParallelDownloads);
    }

    public FileDownloadTask download(FileDownloadRequest request) {
        return dispatcher.enqueue(request);
    }

    public void pauseAll() {
        dispatcher.pauseAll();
    }

    public void resumeAll() {
        dispatcher.resumeAll();
    }

    public void cancelAll() {
        dispatcher.cancelAll();
    }

    public List<FileDownloadTask> activeTasks() {
        return dispatcher.getActiveTasks();
    }
}
