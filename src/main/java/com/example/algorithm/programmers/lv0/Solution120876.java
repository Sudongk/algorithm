package com.example.algorithm.programmers.lv0;
public class Solution120876 {
    // lines : [[0, 1], [2, 5], [3, 9]]
    // result : 2
    public int solution(int[][] lines) {
        // 1. arr 배열 및 변수 초기화
        int[] arr = new int[200];
        int answer = 0;

        // 2. lines 정보를 arr 배열에 적용
        for(int i = 0; i < lines.length; i++)
            // 음수를 위한 +100
            for(int j = lines[i][0] + 100; j < lines[i][1] + 100; j++)
                arr[j]++;

        // 3. arr 배열에서 겹친 부분 세기
        for(int i = 0; i < 200; i++)
            if(arr[i] > 1)
                answer++;



        return answer;
    }

    public static void main(String[] args) {
//        int[][] lines = {{0, 5}, {3, 9}, {1, 10}};
//        int[][] lines = {{-1, 0}, {0, 1}, {1, 2}};
//        int[][] lines = {{-1, 1}, {1, 3}, {3, 9}};
        int[][] lines = {{0, 1}, {2, 5}, {3, 9}};

        Solution120876 solution120876 = new Solution120876();
        System.out.println(solution120876.solution(lines));
    }
}
