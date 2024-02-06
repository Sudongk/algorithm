package com.example.algorithm.programmers.lv2;

import java.util.*;

public class Solution42583 {

    // bridge_length : 2
    // weight : 10
    // truck_weights : [7, 4, 5, 6]
    // return : 8

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int passed_truck_count = 0;
        int truck_idx = 0;
        int total_truck_weight = 0;
        Queue<Integer> bridge = new LinkedList<>();

        while (passed_truck_count != truck_weights.length) {
            // 다리를 건너는 트럭의 개수가 다리의 길이와 같다면 다리 끝에 도착을 의미
            if (bridge.size() == bridge_length) {
                // 다리 끝에 있는 요소 꺼냄
                Integer truck_weight = bridge.poll();
                // 꺼낸 요소가 트럭이라면 지난 트럭 갯수 증가, 다리에 있는 트럭 총 무게 감소
                if (truck_weight != 0) {
                    passed_truck_count++;
                    total_truck_weight = total_truck_weight - truck_weight;
                }
            }

            // 다리가 수용 가능한 무게라면 다리에 트럭 추가 후 트럭 총 무게 증가, 트럭 인덱스 증가, 시간 증가
            if (truck_idx < truck_weights.length && total_truck_weight + truck_weights[truck_idx] <= weight) {
                bridge.add(truck_weights[truck_idx]);
                total_truck_weight = total_truck_weight + truck_weights[truck_idx];
                truck_idx++;
                // 시간 증가 후 다음 루프로 이동
                answer++;
                continue;
            }

            // 아니라면 0추가
            bridge.add(0);

            // 시간 증가
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        Solution42583 solution = new Solution42583();

        System.out.println(solution.solution(bridge_length, weight, truck_weights));
    }

}
