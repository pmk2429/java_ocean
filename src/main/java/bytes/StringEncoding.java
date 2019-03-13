package bytes;

import java.nio.charset.StandardCharsets;

/**
 * Converts String using one of the six Standard Charsets.
 */
public class StringEncoding {

    protected static byte[] getUTF_8(String str) {
        return str != null ? str.getBytes(StandardCharsets.UTF_8) : null;
    }

    protected static byte[] getUTF_16(String str) {
        return str != null ? str.getBytes(StandardCharsets.UTF_16) : null;
    }

    protected static byte[] getUTF_16BE(String str) {
        return str != null ? str.getBytes(StandardCharsets.UTF_16BE) : null;
    }

    protected static byte[] getUTF_16LE(String str) {
        return str != null ? str.getBytes(StandardCharsets.UTF_16LE) : null;
    }

    protected static byte[] getUS_ASCII(String str) {
        return str != null ? str.getBytes(StandardCharsets.US_ASCII) : null;
    }

}