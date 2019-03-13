package _arraylist;

import java.util.*;

public class RemoveDuplicates {

  private static void removeDuplicates(List<Integer> numbers) {
    Set<Integer> uniqueNums = new LinkedHashSet<>(numbers);
    numbers.clear();
    numbers.addAll(uniqueNums);
    System.out.println(Arrays.asList(numbers));
  }

  public static void main(String[] args) {
    List<Integer> nums = new ArrayList<Integer>();
    nums.add(1);
    nums.add(2);
    nums.add(3);
    nums.add(4);
    nums.add(3);
    nums.add(6);
    nums.add(5);

    removeDuplicates(nums);
  }
}
