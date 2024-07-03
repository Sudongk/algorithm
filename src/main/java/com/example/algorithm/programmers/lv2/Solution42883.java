package com.example.algorithm.programmers.lv2;

public class Solution42883 {

    // number : "1924" / "1231234" / "4177252841"
    // k : 2 / 3 / 4
    // return : "94" / "3234" / "775841"

    public String solution(String number, int k) {
        String answer = "";

        String[] num_arr = number.split("");

        int len = number.length() - k;
        int start = 0;
        int end = k;

        for (int i = 0; i < len; i++) {
            int max = 0;
            int idx = 0;

            for (int j = start; j <= end; j++) {
                int num = Integer.parseInt(num_arr[j]);

                if (max < num) {
                    max = num;
                    idx = j;
                }
            }

            answer += max;
            start = idx + 1;
            end++;
        }

        return answer;
    }

    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;

        Solution42883 solution = new Solution42883();

        String answer = solution.solution(number, k);

        System.out.println(answer);
    }

}
