package com.practice.recursion;

import java.util.Arrays;

public class NQueen {

	public boolean placeNQueen(int n) {
		Position[] position = new Position[n];
		
		boolean flag = placeNQueens(n, 0, position);
		System.out.println("Positions:"+Arrays.toString(position));
		return flag;
	}

	private boolean placeNQueens(int n, int row, Position[] positions) {
		if (n == row) {
			return true;
		}
		for (int col = 0; col < n; col++) {
			boolean safe = true;
			for (int queen = 0; queen < row; queen++) {
				if (positions[queen].col == col // if any of the queen in the
												// same column
						|| positions[queen].row - positions[queen].col == row - col // if
																					// any
																					// of
																					// the
																					// queen
																					// in
																					// the
																					// left
																					// diagonal(\)
						|| positions[queen].row + positions[queen].col == row + col)// if
																					// any
																					// of
																					// the
																					// queen
																					// in
																					// the
																					// right
																					// diagonal(/)
				{
					safe = false;
					break;
				}
			}
			if (safe) {
				positions[row] = new Position(row, col);
				if (placeNQueens(n, row + 1, positions)) {
					return true;
				}
				positions[row] = null;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		NQueen q = new NQueen();
		System.out.println(q.placeNQueen(5));
	}
}

class Position {
	int row, col;

	Position(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public String toString() {
		return "(" + this.row + ", " + this.col + ") ";
	}
}