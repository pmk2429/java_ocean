package misc;

public class MatrixTranspose {
	public static void main(String[] args) {
		int[][] mainMatrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int transposeMatrix[][] = new int[mainMatrix.length][mainMatrix[0].length];

		MatrixTranspose mt = new MatrixTranspose();
		
		System.out.println("Original Matrix:");
		mt.printMatrix(mainMatrix);
		transposeMatrix = mt.transposeMatrix(mainMatrix);
		System.out.println("\nTranspose Matrix:");
		mt.printMatrix(transposeMatrix);

	}

	public int[][] transposeMatrix(int[][] mainMatrix) {
		int[][] matrix = mainMatrix;
		int rows = matrix.length;
		int columns = matrix[0].length;
		int[][] transposeMatrix = new int[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				transposeMatrix[i][j] = matrix[j][i];
			}
		}
		return transposeMatrix;
	}

	public static void printMatrix(int[][] matrix) {
		int columns = matrix[0].length;
		int rows = matrix.length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
