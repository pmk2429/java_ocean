package sysdesign.filepicker;

import java.io.File;

/**
 * This class interacts with the system's functionalities for opening camera and file manager.
 */
public class FileManager {
    public File getCameraFile() {
        // Implement logic to create a temporary file for capturing image
        // ...
        return new File("");
    }

    public void openCameraIntent(File outputFile, long maxSize) {
        // Implement logic to create and open camera intent with output file and size limit
        // ...
    }

    public void openDocumentIntent(String[] allowedMimeTypes) {
        // Implement logic to open document picker intent with optional mime type filtering
        // ...
    }

    public String getFileName(Uri uri) {
        // Optional - can be delegated to StorageManager
        return null; // Implement logic to get filename from Uri
    }

    public String getMimeType(Uri uri) {
        // Implement logic to get mime type from Uri (optional - useful for checking file type)
        // ...
        return null;
    }
}
