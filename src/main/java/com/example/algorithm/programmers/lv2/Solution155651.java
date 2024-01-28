package com.example.algorithm.programers.lv2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution155651 {
    // book_time : [["15:00", "17:00"], ["16:40", "18:20"], ["14:20", "15:20"], ["14:10", "19:20"], ["18:20", "21:20"]]
    // answer : 3
    public int solution(String[][] book_time) {
        // 예약 정보를 시작 시간을 기준으로 정렬
        Arrays.sort(book_time, (a, b) -> {
            return a[0].compareTo(b[0]);
        });

        int rooms = 0;
        PriorityQueue<String> endTimes = new PriorityQueue<>();

        for (String[] reservation : book_time) {
            String startTime = reservation[0];
            String endTime = reservation[1];

            // 현재 예약의 시작 시간보다 이전에 끝난 예약을 제거
            while (!endTimes.isEmpty() && endTimes.peek().compareTo(startTime) <= 0) {
                endTimes.poll();
            }

            // 현재 예약을 추가하고 퇴실 시간을 우선순위 큐에 넣음
            endTimes.offer(endTime);

            // 현재 객실의 수와 필요한 객실의 수를 비교하여 업데이트
            rooms = Math.max(rooms, endTimes.size());
        }

        return rooms;
    }

    public static void main(String[] args) {
        String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};

        Solution155651 solution155651 = new Solution155651();
        System.out.println(solution155651.solution(book_time));
    }
}
