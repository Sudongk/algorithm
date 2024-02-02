package com.example.algorithm;

public class StringNumToIntNum {

    public static void main(String[] args) {
        String a = "12345";
        int i = 0;

        for (int j = 0; j < a.length(); j++) {
            i *= 10;
            i += a.charAt(j) - '0';
        }

        System.out.println(i);
    }

}
