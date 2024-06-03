package com.example.algorithm.programmers.lv2;

public class Solution42860 {

    // name : "JEROEN"
    // return : 56

    public int solution(String name) {
        int answer = 0;

        int length = name.length();

        // 최대로 가질 수 있는 최대 이동 횟수
        int minMove = length - 1;

        for (int i = 0; i < length; i++) {
            // 알파벳 변경 횟수
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            // 다음 알파벳이 A인 경우
            int next = i + 1;
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }

            // i번째 문자를 변경하고 다음 문자가 A가 아닌 경우
            minMove = Math.min(minMove, i + length - next + Math.min(i, length - next));
        }

        answer += minMove;

        return answer;
    }

    public static void main(String[] args) {
        String name = "JEROEN";

        Solution42860 solution = new Solution42860();

        int answer = solution.solution(name);

        System.out.println(answer);
    }

}
