package sysdesign.filepicker;

import java.io.File;

/**
 * This class handles storing captured and picked files.
 */
public class StorageManager {
    public void storeCapturedImage(File imageFile) {
        // Implement logic to store captured image file
        // ...
    }

    public void storePickedFile(File file) {
        // Implement logic to store picked file
        // ...
    }

    public File getFile(Uri uri) {
        return null; // Implement logic to retrieve file from Uri
    }

    public String getFileName(Uri uri) {
        // Can be implemented here or delegated to FileManager for consistency
        return getFile(uri).getName();
    }
}
