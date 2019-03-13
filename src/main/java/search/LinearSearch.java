package search;

import java.util.Scanner;

public class LinearSearch {
  public static void main(String[] args) {
    int data, arr[], n, i, position = 0;
    boolean flag = false;
    Scanner in = new Scanner(System.in);
    System.out.println("Enter total number of elements:");
    System.out.print("> ");
    n = in.nextInt();
    arr = new int[n];
    System.out.println("Enter " + n + " data elements for Array:");
    i = 0;
    while (i < n) {
      arr[i] = in.nextInt();
      i++;
    }
    System.out.println("Enter the element to find its position: ");
    System.out.print("> ");
    data = in.nextInt();
    
    for (int j = 0; j < arr.length; j++) {
      if (arr[j] == data) {
        position = j + 1;
        flag = true;
        break;
      } else {
        flag = false;
      }
    }
    System.out.println();
    if (flag) {
      System.out.println(data + " found at " + position + " position");
    }
  }
}
