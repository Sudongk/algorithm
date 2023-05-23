package com.example.algorithm.programers.permutation;

/**
 * Redundant Permutation(중복 순열): 서로 다른 n개에서 중복이 가능하게 r개를 뽑아서 정렬하는 경우의 수
 * ex) [1, 1] , [2, 2] 가능
 * */
public class RedundantPermutation {
    public static void redundantPermutation(int[] arr, int[] out, int depth, int r){
        if(depth == r){
            for(int num : out) System.out.print(num);
            System.out.println();
            return;
        }

        for(int i=0; i<arr.length; i++){
            out[depth] = arr[i];
            redundantPermutation(arr, out, depth + 1, r);
        }
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 3};
        // 2개 뽑기
        int r = 2;
        redundantPermutation(arr, new int[r], 0, r);
    }
}
