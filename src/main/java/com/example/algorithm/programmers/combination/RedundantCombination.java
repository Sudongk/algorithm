package com.example.algorithm.programmers.combination;

/**
 * Combination(조합) : 서로 다른 n개에서 순서 상관있이 r개를 뽑는 경우의 수
 * ex) [1, 2] , [2, 1] 는 서로 같다.
 * */
public class RedundantCombination {
    public static void combination(int[] arr, int[] out, int start, int depth, int r){
        if(depth == r){
            for(int num : out) System.out.print(num);
            System.out.println();
            return;
        }
        for(int i=start; i<arr.length; i++){
            out[depth] = arr[i];
            combination(arr, out, i, depth+1, r);
        }
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 3};
        int r = 2;
        combination(arr, new int[r], 0, 0, r);
    }
}
