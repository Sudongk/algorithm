package com.example.algorithm.programers;

public class Solution178870 {
    // sequence : [1, 2, 3, 4, 5]
    // k : 7
    // result : [2, 3]
    public static int[] solution(int[] sequence, int k) {
        int[] answer = new int[] {0, sequence.length - 1};

        // find the shortest subsequence that the sum == k
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < sequence.length) {
            sum += sequence[right];
            while (sum > k) {
                sum -= sequence[left];
                left++;
            }
            if (sum == k) {
                if (right - left < answer[1] - answer[0]) {
                    answer[0] = left;
                    answer[1] = right;
                }
            }
            right++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] sequence = {1, 2, 3, 4, 5};
        int k = 7;
        int[] solution = solution(sequence, k);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
