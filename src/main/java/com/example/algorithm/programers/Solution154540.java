package com.example.algorithm.programers;

public class Solution154540 {
    // maps : ["X591X","X1X5X","X231X", "1XXX1"]
    // result : [1, 1, 27]
    // maps : ["XXX","XXX","XXX"]
    // result : [-1]
    public static int[] solution(String[] maps) {
        int[] answer = {};

        String[][] matrix = new String[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            String[] s = maps[i].split("");
            for (int j = 0; j < s.length; j++) {
                matrix[i][j] =  s[j];
            }
        }

       // 상, 하, 좌, 우우
       int[] x = {0, 0, -1, 1};
       int[] y = {1, -1, 0, 0};
       int[] result =  {};
       int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                for (int k = 0; k < x.length; k++) {
                    int a = i + x[k];
                    int b = j + y[k];
                    if (a >= 0 && a < matrix.length) {
                        if (b >= 0 && b < matrix[i].length) {
                            if (!matrix[a][b].equals("X")) {
                                System.out.println("matrix : " + matrix[a][b]);
                                matrix[a][b] = "X";
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] maps = {"X591X", "X1X5X", "X231X", "1XXX1"};
        System.out.println(solution(maps));
    }
}
