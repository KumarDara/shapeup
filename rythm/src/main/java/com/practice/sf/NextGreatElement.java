package com.practice.sf;

import java.util.Arrays;

public class NextGreatElement {

	public void nextGE(int[] input) {
		int[] geArr = new int[input.length];
		geArr[input.length-1] = -1;
		int max = input[input.length-1];
		for(int i=input.length-2; i>=0; i--) {
			if(input[i] < max) {
				geArr[i] = max;
			} else {
				max = input[i];
			}
		}
		
		System.out.println(Arrays.toString(geArr));
	}
	
	public static int test() {
		int a = 5;
		try {
			throw new Exception("aabc");
			//return 3;
		} catch(Exception e) {
			System.out.println("returning "+2);
			return 2;
		} finally {
			System.out.println("returning "+a);
			//return a;
		}
	}
	
	public static void main(String[] args) {
		/*NextGreatElement nge = new NextGreatElement();
		nge.nextGE(new int[]{5,4,1,2,6});*/
		int a = test();
		System.out.println("got:"+a);
	}
}
