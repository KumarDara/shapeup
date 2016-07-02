package com.practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ConvertToWord {
	 private static String[] words = new String[] {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen",
			    "Fifteen","Sixteen","Seventeen","Eighteen","Nineteen","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety","Hundred","Thousand","Lakh","Million"};
			    private static int[] nos = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90,100,1000,100000,1000000};
			    private static Map<Integer,String> wordsMap = new HashMap<Integer,String>();
			    static{
			        for(int i=0; i<nos.length;i++) {
			            wordsMap.put(nos[i],words[i]);
			        }
			    }
			  public static void main(String[] args) throws IOException {
			    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			    String s;
			    while ((s = in.readLine()) != null) {
			      System.out.println(getAmountInWords(s));
			    }
			  }
			  
			  public static String getAmountInWords(String input) {
			      if(input != null) {
			        int no = Integer.parseInt(input);
			        StringBuilder bldr = new StringBuilder();
			        no = processMillions(no, bldr);
			        no = processLakhs(no,bldr);
			        no = processThousands(no,bldr);
			        no = processHundreds(no,bldr);
			        no = processTens(no,bldr);
			        no = processDigits(no,bldr);
			        bldr.append("Dollars");
			        return bldr.toString();
			      } else {
			          throw new IllegalArgumentException("Please specify a valid value to process");
			      }
			     
			  }
			  
			  public static int processMillions(int input, StringBuilder bldr) {
			     if(input >= 1000000) {
			         int tmpRem = input%1000000;
			         int tmpDiv = input/1000000;
			         
			         bldr.append(wordsMap.get(tmpDiv)).append(wordsMap.get(1000000));
			         return tmpRem;
			     }
			     return input; 
			  }
			  
			  public static int processLakhs(int input, StringBuilder bldr) {
			     if(input >= 100000) {
			         int tmpRem = input%100000;
			         int tmpDiv = input/100000;
			         
			         bldr.append(wordsMap.get(tmpDiv)).append(wordsMap.get(100000));
			         return tmpRem;
			     }
			     return input; 
			  }
			  
			  public static int processThousands(int input, StringBuilder bldr) {
			      if(input >= 1000) {
			         int tmpRem = input%1000;
			         int tmpDiv = input/1000;
			         
			         bldr.append(wordsMap.get(tmpDiv)).append(wordsMap.get(1000));
			         return tmpRem;
			     }
			      return input;
			  }
			  
			  public static int processHundreds(int input, StringBuilder bldr) {
			      if(input >= 100) {
			         int tmpRem = input%100;
			         int tmpDiv = input/100;
			         
			         bldr.append(wordsMap.get(tmpDiv)).append(wordsMap.get(100));
			         return tmpRem;
			     }
			      return input;
			  }
			  
			  public static int processTens(int input, StringBuilder bldr) {
			      if(input >= 21) {
			         int tmpRem = input%10;
			         int tmpDiv = input - tmpRem;
			         
			         bldr.append(wordsMap.get(tmpDiv));
			         return tmpRem;
			     }
			      return input;
			  }
			  
			  public static int processDigits(int input, StringBuilder bldr) {
			      if(input > 0) {
			         bldr.append(wordsMap.get(input));
			     
			     }
			      return input;
			  }
}
