package com.example.algorithm.programmers.lv2;

public class Solution84512 {

    // word : "AAAAE" / "AAAE" / "I" / "EIO
    // return : 6 / 10 / 1563 / 1189
    public int solution(String word) {
        int answer = 0;

        // 풀이 설명
        // 1. 모음 배열을 만든다.
        // 2. 각 모음 별로 가중치를 부여한다.
        // 3. 각 자리수 별로 가중치를 부여한다.
        // 4. 각 자리수 별로 모음이 나오면 가중치를 더한다.

        // 모음 배열
        String[] vowels = {"A", "E", "I", "O", "U"};

        // 가중치 배열
        int[] multipliers = {781, 156, 31, 6, 1};

        // 각 자리수 별로 가중치를 더한다.
        for (int i = 0; i < word.length(); i++) {
            // 각 자리수 별로 모음이 나오면 가중치를 더한다.
            for (int j = 0; j < vowels.length; j++) {
                // 모음이 나오면 가중치를 더한다.
                if (vowels[j].equals(String.valueOf(word.charAt(i)))) {
                    // 가중치를 더한다.
                    answer += 1 + j * multipliers[i];
                    // 모음이 나오면 종료
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String word = "AAAAE";

        Solution84512 solution = new Solution84512();

        int answer = solution.solution(word);

        System.out.println(answer);
    }

}
