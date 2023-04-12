package com.example.algorithm.programers;

public class Solution172928 {
    // park : ["SOO","OOO","OOO"]
    // routes : ["E 2","S 2","W 1"]
    // result : [2,1]
    public static int[] solution(String[] park, String[] routes) {
        // 강아지의 현재 좌표를 탐색 (시작지점)
        int[] currentPos = {0, 0};
        for (int i = 0; i < park.length; i++) {
            if (park[i].contains("S")) {
                currentPos[0] = i;
                currentPos[1] = park[i].indexOf("S");
            }
        }

        for (String route : routes) {
            String[] command = route.split(" ");
            String direction = command[0];
            int move = Integer.parseInt(command[1]);
            int[] cors = {0, 0};

            // ex) cors = [0,0] -> [0, 1]
            if (direction.equals("E")) {
                cors[1]++;
            // ex) cors = [0,0] -> [0, -1]
            } else if (direction.equals("W")) {
                cors[1]--;
            // ex) cors = [0,0] -> [1, 0]
            } else if (direction.equals("S")) {
                cors[0]++;
            // ex) cors = [0,0] -> [-1, 0]
            } else if (direction.equals("N")) {
                cors[0]--;
            }

            // 맵을 벗어나는지 확인
            int nX = currentPos[0] + (cors[0] * move); // 0 + (0 * 0) = 0
            int nY = currentPos[1] + (cors[1] * move); // 0 + (1 * 2) = 2

            if (nX < 0 || nX >= park.length || nY < 0 || nY >= park[0].length()) {
                continue;
            }

            // 장애물을 만나는지 확인
            boolean meetObstacle = false;
            int tempX = currentPos[0];
            int tempY = currentPos[1];

            for (int i = 1; i <= move; i++) {
                tempX += cors[0];
                tempY += cors[1];
                if (park[tempX].charAt(tempY) == 'X') {
                    meetObstacle = true;
                    break;
                }
            }

            if (meetObstacle) {
                continue;
            }

            // 문제가 없으면 이동
            currentPos[0] = nX;
            currentPos[1] = nY;
        }

        return currentPos;
    }

    public static void main(String[] args) {
        String[] park = {"SOO","OOO","OOO"};
        String[] routes = {"E 2","S 2","W 1"};
        System.out.println(solution(park, routes));
    }
}
