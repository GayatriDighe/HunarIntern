package com.task2;
import java.util.Scanner;
public class TicTacToe {

	 private static char[][] board = { {' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '} };
	    private static char currentPlayer = 'X';

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        boolean playAgain;

	        System.out.println("Welcome to Tic Tac Toe!");
	        System.out.println("Players take turns placing 'X' and 'O' on the board.");
	        System.out.println("The first to get three in a row (horizontally, vertically, or diagonally) wins!");

	        do {
	            resetBoard();
	            boolean gameWon = false;
	            int moves = 0;

	            while (!gameWon && moves < 9) {
	                printBoard();
	                System.out.println("Player " + currentPlayer + ", enter your move (row and column: 1-3): ");
	                
	                int row, col;
	                while (true) {
	                    row = scanner.nextInt() - 1;
	                    col = scanner.nextInt() - 1;
	                    
	                    if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
	                        board[row][col] = currentPlayer;
	                        break;
	                    } else {
	                        System.out.println("Invalid move. Try again.");
	                    }
	                }

	                gameWon = checkWinner();
	                if (gameWon) {
	                    printBoard();
	                    System.out.println("Player " + currentPlayer + " wins!");
	                } else if (++moves == 9) {
	                    printBoard();
	                    System.out.println("It's a tie!");
	                } else {
	                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
	                }
	            }

	            System.out.println("Do you want to play again? (yes/no): ");
	            playAgain = scanner.next().equalsIgnoreCase("yes");

	        } while (playAgain);

	        System.out.println("Thanks for playing!");
	        scanner.close();
	    }

	    private static void resetBoard() {
	        for (int i = 0; i < 3; i++)
	            for (int j = 0; j < 3; j++)
	                board[i][j] = ' ';
	        currentPlayer = 'X';
	    }

	    private static void printBoard() {
	        System.out.println("  1 2 3");
	        for (int i = 0; i < 3; i++) {
	            System.out.print((i + 1) + " ");
	            for (int j = 0; j < 3; j++) {
	                System.out.print(board[i][j]);
	                if (j < 2) System.out.print("|");
	            }
	            System.out.println();
	            if (i < 2) System.out.println("  -----");
	        }
	    }

	    private static boolean checkWinner() {
	        for (int i = 0; i < 3; i++) {
	            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) || 
	                (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer))
	                return true;
	        }

	        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) || 
	               (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
	    }
			

	}


