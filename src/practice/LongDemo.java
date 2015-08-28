package practice;

public class LongDemo {
	public static void main(String[] args) {
		int[] values = { 8, 6, 6 };

		int counter = 2;
		int totalStart = 0;
		while (counter > 0) {
			totalStart = totalStart + values[counter - 1];
			counter--;
		}
		int startFinal = totalStart + 1;
		System.out.println(startFinal);

		int counterData[] = new int[3];
		for (int i = 0; i < counterData.length; i++) {
			counterData[i] = i;
			System.out.println(counterData[i]);
		}

		int a = 2;
		int i = 1;
		while (i < a) {
			System.out.println("->" + i);
			i++;
		}
	}
}
