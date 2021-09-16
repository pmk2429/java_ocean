package strings;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class RemoveDuplicates {
  public static void main(String[] args) {
    List<Character> noDuplicate;
    System.out.println("Enter the String:");
    System.out.print("> ");
    Scanner input = new Scanner(System.in);
    String inputString = input.next();
    input.close();

    RemoveDuplicates removeObj = new RemoveDuplicates();
    noDuplicate = removeObj.removeDuplicates(inputString);
    removeObj.printModifiedString(noDuplicate);

    List<Integer> numList = new ArrayList<>();
    numList.add(1);
    numList.add(2);
    numList.add(3);
    numList.add(1);

    removeObj.findDuplicates(numList);
  }

  private void printModifiedString(List<Character> noDuplicate) {
    for (int i = 0; i < noDuplicate.size(); i++) {
      System.out.print(noDuplicate.get(i) + " ");
    }
  }

  public List<Character> removeDuplicates(String inputString) {
    List<Character> singleChars = new ArrayList<Character>();
    for (int i = 0; i < inputString.length(); i++) {
      if (!singleChars.contains(inputString.charAt(i))) {
        singleChars.add(inputString.charAt(i));
      } else {
        continue;
      }
    }
    return singleChars;
  }

  public void findDuplicates(List<Integer> numList) {
    for (int i = 0; i < numList.size(); i++) {
      for (int j = i + 1; j < numList.size(); j++) {
        if (numList.get(i) == numList.get(j)) {
          System.out.println(numList.get(j));
        }
      }
    }
  }
}
