package matrix;

public class MatrixTranspose {
    public int[][] transposeMatrix(int[][] mainMatrix) {
        int rows = mainMatrix.length;
        int columns = mainMatrix[0].length;
        int[][] transposeMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposeMatrix[i][j] = mainMatrix[j][i];
            }
        }
        return transposeMatrix;
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

    public static void main(String[] args) {
        int[][] mainMatrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] transposeMatrix;

        MatrixTranspose mt = new MatrixTranspose();

        System.out.println("Original Matrix:");
        printMatrix(mainMatrix);
        transposeMatrix = mt.transposeMatrix(mainMatrix);
        System.out.println("\nTranspose Matrix:");
        printMatrix(transposeMatrix);
    }

}
