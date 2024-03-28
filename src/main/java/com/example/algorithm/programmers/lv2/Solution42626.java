package com.example.algorithm.programmers.lv2;

import java.util.PriorityQueue;

public class Solution42626 {

    // scoville : [1, 2, 3, 9, 10, 12]
    // K : 7
    // return : 2

    public int solution(int[] scoville, int K) {
        // 자바의 최소 힙 (부모 노드가 자식 노드보다 작거나 같은 완전 이진 트리)
        // poll()하면 가장 작은 값 반환
        PriorityQueue<Integer> pq = new PriorityQueue<>();


        // 최소 힙을 유지하면서 모든 음식의 스코빌 지수를 큐에 삽입
        for (int s : scoville)
            pq.offer(s);

        int count = 0;
        // 최소값이 K 이상이 될 때까지 반복
        while (pq.peek() < K) {
            // 음식이 한 개만 남았는데도 K 이상의 스코빌 지수를 만들 수 없는 경우
            if (pq.size() == 1)
                return -1;

            // 가장 맵지 않은 음식과 두 번째로 맵지 않은 음식을 섞어 새로운 음식의 스코빌 지수 계산
            int mixedScoville = pq.poll() + (pq.poll() * 2);
            // 다시 정렬
            pq.offer(mixedScoville);

            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        Solution42626 solution = new Solution42626();

        System.out.println(solution.solution(scoville, K));
    }

}
