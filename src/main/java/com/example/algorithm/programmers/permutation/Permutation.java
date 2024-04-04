package com.example.algorithm.programmers.permutation;

/**
 * Permutation(순열): 서로 다른 n개에서 r개를 순서에 상관있게 뽑는 경우의 수
 * ex) [1, 2] , [2, 1] 는 서로 다름
 * */
public class Permutation {
    public static void permutation(int[] arr, int[] out, boolean[] visited, int depth, int r) {
        if (depth == r) { // 뽑으려는 갯수 r과 depth가 같으면 출력
            for (int num : out) System.out.print(num + " ");
            System.out.println();
            return; // 재귀함수 탈출?
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, out, visited, depth + 1, r);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 0, 2};
        // 3개 뽑기
        int r = 3;
        permutation(arr, new int[r], new boolean[arr.length], 0, r);
    }
}
