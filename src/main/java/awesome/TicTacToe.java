package awesome;

import java.util.Scanner;

public class TicTacToe {
	private char[][] board;
	private char player;

	public TicTacToe() {
		board = new char[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = '@';
			}
		}
		player = 'X';
	}

	// play method checks for the input by user and then sets the INPUT as
	public boolean play(String s) {
		String[] arr = s.split(" ");
		boolean checkPlay = false;
		int row = Integer.parseInt(arr[0]);
		int col = Integer.parseInt(arr[1]);

		if ((row >= 0) && (row < 3)) {
			if ((col >= 0) && (col < 3)) {
				if (board[row][col] == '@') {
					board[row][col] = player;
					checkPlay = true;
				} else {
					System.out.println("Board value: " + board[row][col]);
				}
			}
		}
		return checkPlay;
	}

	public void switchTurn() {
		if (player == 'O') {
			player = 'X';
		} else {
			player = 'O';
		}
	}

	// won() method determines whether the current player has win the game or
	// not!
	public boolean won() {
		boolean playerWon = false;
		for (int j = 0; j < 3; j++) {
			if ((board[0][j] != '@' && board[0][j] == board[1][j] && board[0][j] == board[2][j])) {
				playerWon = true;
			} else if ((board[j][0] != '@' && board[j][0] == board[j][1] && board[j][0] == board[j][2])) {
				playerWon = true;
			} else if ((board[2][2] != '@' && board[2][2] == board[1][1] && board[2][2] == board[0][0])) {
				playerWon = true;
			} else if ((board[2][0] != '@' && board[2][0] == board[1][1] && board[2][0] == board[0][2])) {
				playerWon = true;
			}
		}
		return playerWon;
	}

	/*
	 * stalemate() method returns true if there are no more places to move on
	 * the board. Otherwise it returns false;
	 */
	public boolean stalemate() {
		boolean isStalemate = true;

		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (board[row][col] == '@') {
					isStalemate = false;
					break;
				}
			}
		}
		return isStalemate;
	}

	// get the Current player
	public char getPlayer() {
		return player;
	}

	// print the TicTacToe board.
	public void print() {
		System.out.println();
		System.out.println("\t  0 1 2");
		System.out.println();
		System.out.println("\tA " + board[0][0] + " | " + board[0][1] + " | "
				+ board[0][2]);
		System.out.println("\t  --------");
		System.out.println("\tB " + board[1][0] + " | " + board[1][1] + " | "
				+ board[1][2]);
		System.out.println("\t  " + "--------");
		System.out.println("\tC " + board[2][0] + " | " + board[2][1] + " | "
				+ board[2][2]);
		System.out.println();

		// System.out.println("PRINT REACHED!!!");
	}

	// execution point of the TicTacToe program
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		TicTacToe game = new TicTacToe();
		System.out.println("Welcome to Tic-Tac-Toe");
		System.out.println("Enter co-ordinates as per the prompts");
		System.out
				.println("*** NOTE: Co ordinates must be whitespace separated and numeric values; Eg: -  1 2 ");

		try {
			while (!game.stalemate()) {
				game.print();

				// get the user input.
				System.out.println("Player is: " + game.player);
				System.out.println("Co-ordinates: ");
				System.out.print("> ");
				String playerCoordinate = in.nextLine();

				// loop and PLAY the current player.
				while (!game.play(playerCoordinate)) {
					System.out
							.println("Co-ordinates entered incorrectly. Let's try again:");
					playerCoordinate = in.next();
				}

				// check is game is win by current player or not.
				if (game.won()) {
					System.out.println("Player " + game.getPlayer()
							+ " Wins!!!!");
					break;
				} else {
					System.out.println("Continue Play...");
				}
				// if game is not win by current player, switch turn.
				game.switchTurn();
			}
			game.print();
			game.switchTurn();
			System.out.println("GAME END...");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			in.close();
		}
	}
}