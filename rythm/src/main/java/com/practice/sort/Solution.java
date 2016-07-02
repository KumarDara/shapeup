package com.practice.sort;

import java.util.*;
import java.util.*;
public class Solution {
       
          static void quickSort(int[] ar) {
                    sort(ar, 0, ar.length-1);
       }
        static void sort(int[] ar, int start, int end) {
            if(start < end) {
                int pivot = pivot(ar, start, end);
                sort(ar, start, pivot -1);
                sort(ar, pivot+1, end);
                printArray(ar);
            }
        }
        static int pivot(int[] ar, int start, int end) {
            int pivot = ar[start];
            int pIndex = start +1;
            for(int i = start+1; i<=end;i++) {
                if(ar[i] <= pivot) {
                    int tmp = ar[i];
                    int tmpI = i;
                    while(tmpI > pIndex) {
                        ar[tmpI] = ar[tmpI-1];
                        tmpI--;
                    }
                    ar[tmpI] = tmp;
                    pIndex++;
                }
            }
            int tmpI = start;
            while(tmpI <pIndex) {
                ar[tmpI] = ar[tmpI+1];
                tmpI++;
            }
            ar[tmpI-1] = pivot;
            return pIndex-1;
        }
 
 static void printArray(int[] ar) {
         for(int n: ar){
            System.out.print(n+" ");
         }
           System.out.println("");
      }
       
      public static void main(String[] args) {
        /*   Scanner in = new Scanner(System.in);
           int n = in.nextInt();
           int[] ar = new int[n];
           for(int i=0;i<n;i++){
              ar[i]=in.nextInt(); 
           }*/
           quickSort(new int[] {5, 8, 1, 3, 7, 9, 2});
       }    
   }
