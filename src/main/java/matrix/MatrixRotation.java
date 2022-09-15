package matrix;

public class MatrixRotation {

	public static void main(String[] args) {
		int[][] mainMatrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int rotatedMatrix[][] = new int[mainMatrix.length][mainMatrix[0].length];
		
		MatrixRotation mr = new MatrixRotation();
		
		System.out.println("Original Matrix:");
		mr.printMatrix(mainMatrix);
		
		rotatedMatrix = mr.rotateMatrix(mainMatrix);
		System.out.println("\nRotated Matrix:");
		mr.printMatrix(rotatedMatrix);
		
	}

	public int[][] rotateMatrix(int[][] mainMatrix) {
		int rows = mainMatrix.length;
		int columns = mainMatrix[0].length;
		int [][]rotateMatrix = new int[rows][columns];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				rotateMatrix[j][rows - 1 - i] = mainMatrix[i][j];
			}
		}
		return rotateMatrix;
	}
	
	public static void printMatrix(int[][] matrix) {
        int columns = matrix[0].length;
        int rows = matrix.length;
		for (int[] ints : matrix) {
			for (int j = 0; j < columns; j++) {
				System.out.print(ints[j] + " ");
			}
			System.out.println();
		}
    }

}
