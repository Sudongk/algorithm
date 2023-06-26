package com.example.algorithm.programers.lv2;

public class Solution181187 {
    // r1 : 2
    // r2 : 3
    // result : 20
    public long solution(int r1, int r2) {
        long result = 0;
        for(int x = 1; x < r2; x++) {
            double inner = Math.sqrt(Math.pow(r1, 2) - Math.pow(x, 2)); //inner는 r1 원의 방정식에서 찾은 y값
            double outer = Math.sqrt(Math.pow(r2, 2) - Math.pow(x, 2)); //outer는 r2 원의 방정식에서 찾은 y값
            long cnt = (long) outer - (long) inner;
            if(isInteger(inner)) cnt++;
            result += cnt * 4;
        }
        return result + (r2 - r1) * 4;
    }
    private boolean isInteger(double val) {
        return val == (long) val;
    }

    public static void main(String[] args) {
        int r1 = 2;
        int r2 = 3;

        Solution181187 solution181187 = new Solution181187();
        System.out.println(solution181187.solution(r1, r2));
    }
}
