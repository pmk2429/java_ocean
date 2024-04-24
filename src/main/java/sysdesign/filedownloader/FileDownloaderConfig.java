package sysdesign.filedownloader;

public class FileDownloaderConfig {

    private final int maxParallelDownloads;

    public FileDownloaderConfig(int maxParallelDownloads) {
        this.maxParallelDownloads = maxParallelDownloads;
    }

    public int getMaxParallelDownloads() {
        return maxParallelDownloads;
    }
}
