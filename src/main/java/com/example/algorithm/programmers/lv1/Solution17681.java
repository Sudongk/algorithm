package com.example.algorithm.programers.lv1;

import java.util.Arrays;

public class Solution17681 {
    // n : 5
    // arr1 : [9, 20, 28, 18, 11]
    // arr2 : [30, 1, 21, 17, 28]
    // result : ["#####","# # #", "### #", "# ##", "#####"]
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] newArr1 = new String[arr1.length];
        String[] newArr2 = new String[arr2.length];

        // n자리의 2진수로 변환
        for (int i = 0; i < n; i++) {
            String binaryString1 = Integer.toBinaryString(arr1[i]);
            newArr1[i] = String.format("%" + n + "s", binaryString1).replace(" ", "0");
            String binaryString2 = Integer.toBinaryString(arr2[i]);
            newArr2[i] = String.format("%" + n + "s", binaryString2).replace(" ", "0");
        }

        for (int i = 0; i < n; i++) {
            String[] newArr1Split = newArr1[i].split("");
            String[] newArr2Split = newArr2[i].split("");
            StringBuilder map = new StringBuilder();
            // 두 배열을 서로 비교해서 둘 다 0인 경우만 공백추가
            for (int j = 0; j < n; j++) {
                if (newArr1Split[j].equals("0") && newArr2Split[j].equals("0")) {
                    map.append(" ");
                } else {
                    map.append("#");
                }
            }

            answer[i]  = map.toString();
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};

        Solution17681 solution17681 = new Solution17681();
        String[] solution = solution17681.solution(n, arr1, arr2);
        System.out.println(Arrays.toString(solution));
    }
}
