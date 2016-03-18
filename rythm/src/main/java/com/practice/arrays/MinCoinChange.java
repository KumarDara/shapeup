package com.practice.arrays;

import java.util.Arrays;

public class MinCoinChange {

	public int minNoofCoins(int[] coins, int sum) {
		int cnt = 0;
		int[] noofCoinsArr = new int[sum + 1];
		int[] possibleCoinsArr = new int[sum + 1];
		possibleCoinsArr[0] = -1;
		for (int i = 1; i <= sum; i++) {
			noofCoinsArr[i] = Integer.MAX_VALUE - 1;
			possibleCoinsArr[i] = -1;
		}
		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (j >= coins[i]) {
					if (noofCoinsArr[j] > (noofCoinsArr[j - coins[i]] + 1)) {
						noofCoinsArr[j] = noofCoinsArr[j - coins[i]] + 1;
						possibleCoinsArr[j] = i;
					}
				}
			}
		}
		cnt = noofCoinsArr[sum];
		printCoins(coins, possibleCoinsArr, sum, cnt);
		return cnt;
	}

	private void printCoins(int[] coins, int[] possibleCoinsArr, int sum, int mincoins) {
		if (possibleCoinsArr[possibleCoinsArr.length - 1] == -1) {
			System.out.println("No solution found");
			return;
		}
		int[] finalcoinsArr = new int[mincoins];
		int i = sum;
		int indx = 0;
		while (i > 0) {
			int coin = coins[possibleCoinsArr[i]];
			finalcoinsArr[indx++] = coin;
			i = i - coin;
		}
		System.out.println(Arrays.toString(finalcoinsArr));
	}
}
