package com.example.algorithm.programmers.lv0;

public class Solution147355 {
    // t : "3141592"
    // p : "271"
    // result : 2
    public int solution(String t, String p) {
        int answer = 0;

        int tLen = t.length();
        int pLen = p.length();

        for (int i = 0; i < tLen - pLen + 1; i++) {
            String partialStr = t.substring(i, i + pLen);
            if (Long.parseLong(partialStr) <= Long.parseLong(p)) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String t = "3141592";
        String p = "271";
        Solution147355 solution147355 = new Solution147355();
        int solution = solution147355.solution(t, p);
        System.out.println(solution);
    }
}
