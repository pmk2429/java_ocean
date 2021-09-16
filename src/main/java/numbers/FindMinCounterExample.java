package numbers;

public class FindMinCounterExample {

  // GIVEN: wrong implementation
  private int find_min(int[] A) {
    int ans = 0;
    for (int i = 1; i < A.length; i++) {
      if (ans > A[i]) {
        ans = A[i];
      }
    }
    return ans;
  }

  // SOLUTION: counter example
  private int[] solution(int N) {
    int[] elements = new int[N];
    // all elements are positive (note the ">1")
    for (int i = 0; i < N; i++) {
      elements[i] = (int) (1 + Math.floor(Math.random() * 100));
    }
    return elements;
  }

  public static void main(String[] args) {
    String s1 = "aabab";
    String s2 = "dog";
    String s3 = "aa";
    String s4 = "baaa";
    String s5 = "aaba";
    System.out.println(maxA(s1));
//    System.out.println(maxA(s2));
//    System.out.println(maxA(s3));
//    System.out.println(maxA(s4));
//    System.out.println(maxA(s5));
  }

  private static int maxA(String s) {
    int aCount = 0, result = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == 'a')
        aCount++;
      else {
        result += 2 - aCount; // if curr char is not a, subtract the count from 2 and add it back to result
        aCount = 0;
      }
      if (aCount == 3) {
        return -1; // when there are 3 consecutive 'a'
      }
    }

    if (s.charAt(s.length() - 1) != 'a') { // last char
      result += 2;
    } else {
      result += 2 - aCount;
    }
    return result;
  }
}
