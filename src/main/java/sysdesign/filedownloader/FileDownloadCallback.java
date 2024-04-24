package sysdesign.filedownloader;

public interface FileDownloadCallback {

    void onComplete(FileDownloadRequest request);

    void onFail(FileDownloadRequest request, String error);

    void onCancel(FileDownloadRequest request);
}
