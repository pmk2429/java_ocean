package sysdesign.filedownloader;

public class FileDownloadRequest {

    private final String sourceUrl;
    private final String destinationPath;
    // You can add additional fields like headers here

    public FileDownloadRequest(String sourceUrl, String destPath) {
        this.sourceUrl = sourceUrl;
        this.destinationPath = destPath;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public String getDestinationPath() {
        return destinationPath;
    }

    // Getters for sourceUrl and destPath
}
