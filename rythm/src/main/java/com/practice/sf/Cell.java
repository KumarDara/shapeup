package com.practice.sf;

public class Cell {

	private int row;
	private int column;

	public Cell(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public String toString() {
		return "(" + row + ", " + column + ")";
	}
}
