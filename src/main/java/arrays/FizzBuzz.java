package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program that outputs the string representation of numbers from 1 to n.
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output
 * “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 * <p>
 * Example:
 * --------
 * n = 15,
 * <p>
 * Return:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 */
public class FizzBuzz {

  private static List<String> fizzBuzz(int n) {
    List<String> fb = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      if (i % 3 == 0) {
        if (i % 5 == 0) {
          fb.add("FizzBuzz");
        }
        fb.add("Fizz");
      } else if (i % 5 == 0) {
        fb.add("Buzz");
      } else {
        fb.add(Integer.toString(i));
      }
    }
    fb.remove(n);
    return fb;
  }

  public static void main(String[] args) {
    int n = 15;
    System.out.println(fizzBuzz(n));
  }
}
