package bytes;

import java.io.IOException;
import java.util.Arrays;


public class BytesCompare {

    private static BytesCompare mBytesCompare = new BytesCompare();

    private static int compareBytes(byte[] source, byte[] match) {
        // sanity checks
        if (source == null || match == null)
            return -1;
        if (source.length == 0 || match.length == 0)
            return -1;
        int ret = -1;
        int spos = 0;
        int mpos = 0;
        byte m = match[mpos];
        for (; spos < source.length; spos++) {
            if (m == source[spos]) {
                // starting match
                if (mpos == 0)
                    ret = spos;
                    // finishing match
                else if (mpos == match.length - 1)
                    return ret;
                mpos++;
                m = match[mpos];
            } else {
                ret = -1;
                mpos = 0;
                m = match[mpos];
            }
        }
        return ret;
    }

    private int compareWindowSize(byte[] arr) {
        return arr.length;
    }

    private void print(byte[] output) throws IOException {
        System.out.println(output.length);
        System.out.write(output);
        System.out.println();
        System.out.println(Arrays.toString(output));
    }

    private void print(String output) {
        System.out.println(output);
    }

    private void init() throws IOException {
        String arr1 = "91.1 and -101.1 and 915584987";

        System.out.println("---UTF-16----");
        byte[] barr1 = StringEncoding.getUTF_8(arr1);
        print(barr1);
    }

    public static void main(String[] args) throws IOException {
        mBytesCompare.init();
    }
}


