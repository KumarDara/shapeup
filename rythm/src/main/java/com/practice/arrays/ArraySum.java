package com.practice.arrays;

import java.util.Scanner;

public class ArraySum {

	public static void main(String[] args) {
		 Scanner scanObj = new Scanner(System.in);
		   int noOfDays = 1000000000;
		   int[] gainNLossArray = new int[noOfDays];
		   for(int i=0; i<gainNLossArray.length;i++) {
		       gainNLossArray[i] = scanObj.nextInt();
		   }
		   StringBuilder s = new StringBuilder("");
		   int totalGain = 0;
		   for(int i=0; i<gainNLossArray.length;i++) {
		       totalGain += gainNLossArray[i];
		   }
		   System.out.println(totalGain);
		
	}
}
