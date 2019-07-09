package numbers;

import java.util.*;

public class RangeOfPrime {
  public static void main(String[] args) {
    System.out.println("Enter the maximum number to find all prime(s).");
    Scanner input = new Scanner(System.in);
    int range = input.nextInt();
    input.close();
    List<Integer> listPrime = new ArrayList<Integer>();
    boolean isPrime = isPrimeNumber(range);
    System.out.println(isPrime);
    listPrime = findAllPrimeNumbers(range);
    System.out.println("\nPrime numbers in range:");
    if (listPrime.size() == 0) {
      System.out.println("Sorry No prime numbers fround in range");
    } else {
      System.out.println("1\n2\n3");
      for (int i = 0; i <= listPrime.size(); i++) {
        System.out.println(listPrime.get(i));
      }
    }
  }

  private static List<Integer> findAllPrimeNumbers(int range) {
    List<Integer> listPrime = new ArrayList<Integer>();
    boolean flag = false;
    for (int i = 4; i <= range; i++) {
      int number = i;
      for (int j = 2; j < number / 2; j++) {
        if (number % j == 0) {
          flag = false;
        } else {
          flag = true;
        }
      }
      if (flag == true) {
        listPrime.add(number);
      }
    }
    return listPrime;
  }

  private static boolean isPrimeNumber(int number) {
    for (int i = 2; i <= number / 2; i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }
}
