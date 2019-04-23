package strings;

/**
 * Read N Characters Given Read4
 * <p>
 * Question:
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * The return value is the actual number of characters read. For example, it returns 3 if there
 * is only 3 characters left in the file.
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 * Note: The read function will only be called once for each test case.
 */
public class Read4 {

  private static int read4(char[] buf) {
    return 0;
  }

  private static char[] buffer = new char[4];
  private static int offset = 0, bufsize = 0;

  /**
   * @param buf Destination buffer
   * @param n   Maximum number of characters to read
   * @return The number of characters read
   */
  private static int readMultiple(char[] buf, int n) {
    int readBytes = 0;
    boolean eof = false;
    while (!eof && readBytes < n) {
      if (bufsize == 0) {
        bufsize = read4(buffer);
        eof = bufsize < 4;
      }
      int bytes = Math.min(n - readBytes, bufsize);
      System.arraycopy(buffer /* src */, offset /* srcPos */, buf /* dest */, readBytes /* destPos */, bytes /* length */);
      offset = (offset + bytes) % 4;
      bufsize -= bytes;
      readBytes += bytes;
    }
    return readBytes;
  }

  private static int read(char[] buf, int n) {
    char[] buffer = new char[4];
    int readBytes = 0;
    boolean eof = false;

    while (!eof && readBytes < n) {
      int totalRead = read4(buffer);
      if (totalRead < 4) {
        eof = true; // indicates end of file
      }
      int bytesLeft = n - readBytes;
      int bytesToCopy = Math.min(bytesLeft, totalRead);
      System.arraycopy(buffer, 0, buf, readBytes, bytesToCopy);
      readBytes += bytesToCopy;
    }
    return readBytes;
  }
}
