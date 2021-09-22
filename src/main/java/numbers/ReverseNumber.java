package numbers;

public class ReverseNumber {
    private static int reverseNumber(int number) {
        int reverse = 0;
        int remainder;

        do {
            remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number / 10;

        } while (number > 0);
        return reverse;
    }

    private static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            // handle overflow/underflow
            if (Math.abs(rev) > Integer.MAX_VALUE / 10) {
                return 0;
            }
            rev = (rev * 10) + (x % 10);
            x /= 10;
        }
        return rev;
    }

    public int reverseUsingStringBuilder(int x) {
        String ans = x < 0
            ? new StringBuilder(String.valueOf(-x)).append("-").reverse().toString()
            : new StringBuilder(String.valueOf(x)).reverse().toString();
        try {
            return Integer.parseInt(ans);
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        int reversedNumber = reverse(-321);
        System.out.println(Integer.MAX_VALUE);
        System.out.println("\nReverse of entered number is: " + reversedNumber);
    }
}
