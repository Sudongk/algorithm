package com.example.algorithm.programmers.lv2;

public class Solution42842 {

    // brown : 10, yellow : 2
    // return : [4, 3]

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        // 전체 사이즈
        int size = brown + yellow;

        int width = 0;
        int length = 0;

        // 가로, 세로 길이 구하기
        for (int i = 1; i <= size; i++) {
            // 약수인 경우
            if (size % i == 0) {
                // size를 i로 나눈 값이 세로 길이
                int newLength = size / i;
                // size를 i로 나눈 나머지가 가로 길이
                int newWidth = i % size;

                int yellowSize = (newWidth - 2) * (newLength - 2);

                // 노란색 카펫의 사이즈와 일치하지 않는 경우
                if (yellowSize != yellow) {
                    continue;
                }

                length = size / i;
                width = i % size;
            }

            // 가로가 세로보다 크거나 같은 경우
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
        int brown = 18;
        int yellow = 6;

        Solution42842 solution = new Solution42842();

        int[] answer = solution.solution(brown, yellow);

        for (int i : answer) {
            System.out.println(i);
        }
    }

}
