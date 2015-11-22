package misc;

import java.util.Scanner;

// the name of our class its public
public class Transpose {
	// void main
	public static void main(String[] args) {
		char m[][] = { {'a','b'}, {'c','d'}, {'e','f'}};
		
		Transpose.rotateMatrix(m);
	}

	public static char[][] rotateMatrix(char[][] matrix) {
		int M = matrix.length;
		int N = matrix[0].length;
		char[][] rot = new char[N][M];
		for (int row = 0; row < M; row++) {
			for (int column = 0; column < N; column++) {
				rot[column][M - 1 - row] = matrix[row][column];
			}
		}
		// Test print
		System.out.println("Rotated Matrix:");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(rot[i][j] + " ");
			}
			System.out.println();
		}
		return rot;
	}
}