package com.example.algorithm.programmers.lv2;

public class Solution42842 {

    // brown : 10, yellow : 2
    // return : [4, 3]

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int size = brown + yellow;

        int width = 0;
        int length = 0;

        for (int i = 1; i <= size; i++) {
            if (size % i == 0) {
                length = size / i;
                width = i % size;
            }

            if (length != 0 && width != 0) {
                if (length <= width) {
                    break;
                }
            }
        }

        answer[0] = width;
        answer[1] = length;

        return answer;
    }

    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;

        Solution42842 solution = new Solution42842();

        int[] answer = solution.solution(brown, yellow);

        for (int i : answer) {
            System.out.println(i);
        }
    }

}
