package arrays;

public class TeemoAttack {

  private static int attackDuration(int[] poisonTime) {
    int totalTime = 0;
    int j = 0;
    for (int i = 0; i < poisonTime.length; i++) {
      j = i + 1;
      if (j < poisonTime.length) {
        if (poisonTime[j] - poisonTime[i] >= 2) {
          totalTime += 2;
        } else {
          totalTime++;
        }
      } else {
        totalTime += 2;
      }
    }

    return totalTime;
  }

  public static void main(String[] args) {
    int[] a = {1, 4, 6, 7};
    int[] b = {1, 2, 3};
    System.out.println(attackDuration(a));
    System.out.println(attackDuration(b));
  }
}
