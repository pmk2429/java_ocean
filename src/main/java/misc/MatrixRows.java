package misc;

/**
 * This class finds the entry in N*M matrix which is 0 and will convert
 * that entire Row and Column to 0; 
 */

import java.util.Random;

public class MatrixRows {
	public static void main(String[] args) {
		MatrixRows matrixObj = new MatrixRows();
		matrixObj.buildMatrix();
	}

	private void buildMatrix() {
		Random randomNo = new Random();
		int[][] matrix = { { 2, 5, 6, }, { 8, 9, 0, }, { 4, 1, 3 } };
		int row[] = new int[matrix.length];
		int column[] = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = 1;
					column[j] = 1;
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("\n");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (row[i] == 1 || column[j] == 1) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
