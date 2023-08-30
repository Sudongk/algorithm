package com.example.algorithm.programers.lv2;

import java.util.HashSet;

public class Solution154538 {
    // x : 10
    // y : 40
    // n : 30
    // result : 1
    public int solution(int x, int y, int n) {

        int cnt = 0;
        HashSet<Integer> curr = new HashSet<>(), next = null;
        curr.add(x);

        while (!curr.isEmpty()) {
            if (curr.contains(y))
                return cnt;
            next = new HashSet<>();
            for (int val : curr) {
                int pVal = val + n;
                int dVal = val * 2;
                int tVal = val * 3;
                if (pVal <= y) next.add(pVal);
                if (dVal <= y) next.add(dVal);
                if (tVal <= y) next.add(tVal);
            }
            curr = next;
            cnt++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int x = 10;
        int y = 40;
        int n = 30;

        Solution154538 solution154538 = new Solution154538();
        System.out.println(solution154538.solution(x, y, n));
    }
}
