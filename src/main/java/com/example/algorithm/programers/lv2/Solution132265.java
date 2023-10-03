package com.example.algorithm.programers.lv2;

import java.util.HashSet;

public class Solution132265 {
    // topping : [1, 2, 1, 3, 1, 4, 1, 2]
    // result : 2
    public int solution(int[] topping) {
        int n = topping.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            HashSet<Integer> set1 = new HashSet<>();
            HashSet<Integer> set2 = new HashSet<>();

            for (int j = 0; j <= i; j++) {
                set1.add(topping[j]);
            }

            for (int j = i + 1; j < n; j++) {
                set2.add(topping[j]);
            }

            if (set1.size() == set2.size()) {
                result++;
            }
        }

        return result;
    }

    // 시간초과
//    public int solution(int[] topping) {
//        int answer = 0;
//
//        for (int n = 0; n < topping.length; n++) {
//            HashSet<Integer> set1 = new HashSet<>();
//            HashSet<Integer> set2 = new HashSet<>();
//
//            for (int i = 0; i <= n; i++) {
//                set1.add(topping[i]);
//            }
//
//            for (int i = n + 1; i < topping.length; i++) {
//                set2.add(topping[i]);
//            }
//
//            if (set1.size() == set2.size()) {
//                answer++;
//            }
//
//            set1.clear();
//            set2.clear();
//        }
//
//        return answer;
//    }

    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};

        Solution132265 solution132265 = new Solution132265();
        System.out.println(solution132265.solution(topping));
    }
}
