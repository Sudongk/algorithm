package com.example.algorithm.programmers;

import java.util.*;

public class Solution161989 {
    // n : 벽 길이
    // m : 롤러 길이
    // section : 칠할 영역
    // 8	4	[2, 3, 6]
    public static int solution(int n, int m, int[] section) {
        int answer = 0;
        int[] newSection = section;

        if (n == m) {
            answer = 1;
            return answer;
        }

        if (m == 1) {
            answer = section.length;
            return answer;
        }

        if (section.length == n) {
            answer = (int) Math.ceil((double) n / m);
            return answer;
        }

        PrimitiveIterator.OfInt iterator = Arrays.stream(newSection).iterator();
        List<Integer> stack = new ArrayList<>();

        for (; iterator.hasNext(); ) {
            Integer next = iterator.next();

            if (stack.contains(next)) {
                continue;
            }

            for (int i = 0; i < m; i++) {
                int val = next + i;

                if (val > n) {
                    break;
                }

                stack.add(val);
            }

            answer += 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] section = {1, 2, 3, 4};
        int result = solution(4, 1, section);
        System.out.println(result);
    }
}