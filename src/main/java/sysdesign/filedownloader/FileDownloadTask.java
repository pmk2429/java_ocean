package sysdesign.filedownloader;

public class FileDownloadTask {

    private final FileDownloadRequest request;

    public FileDownloadTask(FileDownloadRequest request) {
        this.request = request;
    }

    public void addDownloadCallback(FileDownloadCallback callback) {
        // Add callback to internal listener list
    }

    public void pause() {
        // Delegate pause call to dispatcher
    }

    public void resume() {
        // Delegate resume call to dispatcher
    }

    public void cancel() {
        // Delegate cancel call to dispatcher
    }

    // Getter for request
}
