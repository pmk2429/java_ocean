package misc;

import java.util.Arrays;

public class FindLargest {
	public static void main(String[] args) {
		int[] arrayNos = { 2, 5, 8, 7, 6, 88, 15, 98, 124, 2429, 447, 56 };
		Arrays.sort(arrayNos);
		for(int i=0;i<arrayNos.length;i++){
			System.out.print(arrayNos[i] + " " );
		}
		int largest = -1;
		for (int i = 0; i < arrayNos.length; i++) {
			if(arrayNos[i] > largest){
				largest = arrayNos[i];
			}
		}
		System.out.println();
		System.out.println("Largest: " + largest);
		
	}
}
