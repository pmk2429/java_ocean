package strings;

import java.util.Arrays;

public class StringCloning {
  public static void main(String[] args) {
    int sum = 0;
    int[] warmup = new int[1];
    warmup[0] = 1;
    for (int i = 0; i < 15000; i++) { // triggers JIT
      sum += copyClone(warmup);
      sum += copyArrayCopy(warmup);
      sum += copyCopyOf(warmup);
    }

    int count = 10_000_000;
    int[] array = new int[count];
    for (int i = 0; i < count; i++) {
      array[i] = i;
    }

    // additional warmup for main
    for (int i = 0; i < 10; i++) {
      sum += copyArrayCopy(array);
    }
    System.gc();
    // copyClone
    long start = System.nanoTime();
    for (int i = 0; i < 10; i++) {
      sum += copyClone(array);
    }
    long end = System.nanoTime();
    System.out.println("clone: " + (end - start) / 1000000);
    System.gc();
    // copyArrayCopy
    start = System.nanoTime();
    for (int i = 0; i < 10; i++) {
      sum += copyArrayCopy(array);
    }
    end = System.nanoTime();
    System.out.println("arrayCopy: " + (end - start) / 1000000);
    System.gc();
    // copyCopyOf
    start = System.nanoTime();
    for (int i = 0; i < 10; i++) {
      sum += copyCopyOf(array);
    }
    end = System.nanoTime();
    System.out.println("Arrays.copyOf: " + (end - start) / 1000000);
    // sum
    System.out.println(sum);
  }

  private static int copyClone(int[] array) {
    int[] copy = array.clone();
    return copy[copy.length - 1];
  }

  private static int copyArrayCopy(int[] array) {
    int[] copy = new int[array.length];
    System.arraycopy(array, 0, copy, 0, array.length);
    return copy[copy.length - 1];
  }

  private static int copyCopyOf(int[] array) {
    int[] copy = Arrays.copyOf(array, array.length);
    return copy[copy.length - 1];
  }
}