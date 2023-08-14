package encoding;

public class AddBinary {
    /**
     * Convert a and b into integers.
     * Compute the sum.
     * Convert the sum back into binary form.
     */
    private static String addBinary(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }

    public static void main(String[] args) {
        String a = "11", b = "1";
        System.out.println(addBinary(a, b));
    }
}
