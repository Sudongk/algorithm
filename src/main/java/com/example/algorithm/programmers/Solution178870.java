package com.example.algorithm.programmers;

public class Solution178870 {
    // sequence : [1, 2, 3, 4, 5]
    // k : 7
    // result : [2, 3]
    // sum == k인 조건을 만족하는 가장 짧은 부분 수열 찾기
    public static int[] solution(int[] sequence, int k) {
        // 처음 인덱스와 끝 인덱스로 초기화
        int[] answer = new int[] {0, sequence.length - 1};

        // 변수 초기화 해주지 않는게 포인트
        // left가 증가하면서 탐색 범위 줄어듬
        int left = 0;
        // right가 증가하면서 탐색 범위 늘어남
        int right = 0;
        // sum은 두 포인터 left와 rigth 사이 숫자들의 총 합
        int sum = 0;

        while (right < sequence.length) {
            sum += sequence[right];
            // sum이 k보다 커지면 또 다른 포인터를 이용해 sum이 k보다 같거나 작아질때까지 포인터 이동
            while (sum > k) {
                sum -= sequence[left];
                left++;
            }
            // sum과 k가 같다면 이전 값과 길이 비교 -> 더 짧으면 값 교체
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
        int[] sequence = {2, 2, 2, 2, 2};
        int k = 6;
        int[] solution = solution(sequence, k);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
