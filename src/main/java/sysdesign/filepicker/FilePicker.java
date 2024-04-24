package sysdesign.filepicker;

import java.io.File;

/**
 * This is the main class responsible for exposing functionalities to the user.
 * It interacts with StorageManager and FileManager.
 */
public class FilePicker {

    private final StorageManager storageManager;
    private final FileManager fileManager;
    private OnFileSelectedListener listener;
    private OnCameraErrorListener cameraErrorListener;

    public FilePicker(StorageManager storageManager, FileManager fileManager) {
        this.storageManager = storageManager;
        this.fileManager = fileManager;
    }

    public void setOnFileSelectedListener(OnFileSelectedListener listener) {
        this.listener = listener;
    }

    public void setOnCameraError(OnCameraErrorListener cameraErrorListener) {
        this.cameraErrorListener = cameraErrorListener;
    }

    public void openCamera(int compressPercentage, long maxSize) {
        // Call FileManager to get camera file and open camera intent with compression and size limit
        File cameraFile = fileManager.getCameraFile();
        fileManager.openCameraIntent(cameraFile, maxSize);

        // Implement logic to handle successful image capture (using callback from FileManager)
        // and call storageManager.storeCapturedImage(cameraFile)
        // ...
    }

    // Similar implementations for openGallery() and pickDOCFile() methods

    public String getFileName(Uri uri) {
        return storageManager.getFileName(uri);
    }

}
