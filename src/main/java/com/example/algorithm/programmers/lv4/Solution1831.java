package com.example.algorithm.programmers.lv4;

import java.util.ArrayList;
import java.util.List;

public class Solution1831 {
    // n : 15
    // result : 1
    public int solution(int n) {
        int answer = 0;
        int starCount = 0;
        List<String> str = new ArrayList<>();

        for (int i = 1; i < 19; i++) {
            int n1 = (int) Math.pow(3, i) + i * 2;
            int n2 = (int) Math.pow(3, i + 1) + (i + 1) * 2;
            if (n >= n1) { starCount++;
                if (n < n2) break;
            }
        }

        for (int i = 1; i <= starCount; i++) {
            str.add("*");
        }

        for (int j = 1; j <= starCount * 2; j++) {
            str.add("+");
        }

        System.out.println(str);

        List<String> part = str.subList(1, str.size() - 1);

        System.out.println(part);

        return answer;
    }

    private static int calculate(String c, int num) {
        int result;

        if (c.equals("*")) {
            result = num * 3;
        } else result = num + 1;

        return result;
    }

    public static void main(String[] args) {
        int n = 41;

        Solution1831 solution1831 = new Solution1831();
        System.out.println(solution1831.solution(n));
    }
}
