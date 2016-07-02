package com.practice.sf;

import java.util.ArrayList;
import java.util.List;

public class MaxSumPathInTriangle {

	public int getMaxSum(int[][] input) {
		int sum = 0;

		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length - 1; j++) {
				sum += Math.max(input[i][j], input[i][j + 1]);
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		int i = 0;
		while(true) {
			List<String> list = new ArrayList<>();
			list.add(++i+"Hello");
			if(i%1000 == 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
