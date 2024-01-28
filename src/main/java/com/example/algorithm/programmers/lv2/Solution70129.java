package com.example.algorithm.programmers.lv2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution70129 {
    // s : "110010101001"
    // result : [3, 8]
    public int[] solution(String s) {
        int[] answer = {0, 0};
        int loopCount = 0;
        int removedZeroCount = 0;
        String newString = s;

        // 1. 문자열의 모든 0 제거 -> 2. 문자열 길이를 2진수로 표현 -> 1, 2 반복
        while (newString.length() > 1) {
            removedZeroCount = removedZeroCount + Arrays.stream(newString.split(""))
                    .filter(c -> c.equals("0"))
                    .collect(Collectors.joining())
                    .length();

            String s1 = removeZero(newString);
            newString = toBinary(s1.length());

            loopCount++;
        }
        answer[0] = loopCount;
        answer[1] = removedZeroCount;

        return answer;
    }

    private String removeZero(String s) {
        return s.replace("0", "");
    }

    private String toBinary(int len) {
        return Integer.toBinaryString(len);
    }

    public static void main(String[] args) {
        String s = "110010101001";
        Solution70129 solution70129 = new Solution70129();
        int[] solution = solution70129.solution(s);
        System.out.println(Arrays.toString(solution));
    }
}
