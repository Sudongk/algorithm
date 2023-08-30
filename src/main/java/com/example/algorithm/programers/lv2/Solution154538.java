package com.example.algorithm.programers.lv2;

public class Solution154538 {
    // x : 10
    // y : 40
    // n : 5
    // result : 2
    public int solution(int x, int y, int n) {
        int cnt = 0;
        while (y > x) {
            if (y % 2 == 0 && y / 2 >= x) {
                y /= 2;
            } else if (y % 3 == 0 && y / 3 >= x && (y / 3) % n != n - 1) {
                y /= 3;
            } else {
                y -= n;
            }
            cnt++;
        }
        return x == y ? cnt : -1;
    }

    public static void main(String[] args) {
        int x = 10;
        int y = 40;
        int n = 5;

        Solution154538 solution154538 = new Solution154538();
        System.out.println(solution154538.solution(x, y, n));
    }
}
