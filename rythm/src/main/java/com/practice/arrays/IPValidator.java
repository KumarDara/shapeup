package com.practice.arrays;

import java.util.Scanner;

public class IPValidator {

	static void validateIP(String ip_address) {
        String[] ipArr = ip_address.split("[.]");
        if(ipArr.length != 4) {
            System.out.println("False");
            return;
        }
        try {
        int v1 = Integer.parseInt(ipArr[0]);
        int v2 = Integer.parseInt(ipArr[1]);
        int v3 = Integer.parseInt(ipArr[2]);
        int v4 = Integer.parseInt(ipArr[3]);
        if(v1 == 0 && v2 == 0 && v3==0 && v4 == 0 ) {
            System.out.println("False");
        } else 
        if(v1 == 255 && v2 == 255 && v3==255 && v4 == 255 ) {
            System.out.println("False");
        } else {
            boolean v1Valid = isValid(v1);
            boolean v2Valid = isValid(v2);
            boolean v3Valid = isValid(v3);
            boolean v4Valid = isValid(v4);
            if(v1Valid && v2Valid && v3Valid && v4Valid) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
        }catch(NumberFormatException e) {
             System.out.println("False");
        }
    }

    static boolean isValid(int no) {
        return no >= 0 && no <= 255;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String _ip_address;
        try {
            _ip_address = in.nextLine();
        } catch (Exception e) {
            _ip_address = null;
        }
        
        validateIP(_ip_address);
        
    }
}
