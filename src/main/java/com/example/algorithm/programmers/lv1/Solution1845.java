package com.example.algorithm.programmers.lv1;

import java.util.*;

public class Solution1845 {
    // nums : [3,1,2,3]
    // result : 2

    public int solution(int[] nums) {
        int target = nums.length / 2;

        int[] type = Arrays.stream(nums).distinct().toArray();

        if (type.length <= target) {
            return type.length;
        } else {
            return target;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 3};

        Solution1845 solution1845 = new Solution1845();
        System.out.println(solution1845.solution(nums));
    }

}
