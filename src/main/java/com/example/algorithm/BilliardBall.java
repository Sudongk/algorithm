package com.example.algorithm;

import static java.lang.Thread.*;

public class BilliardBall {
    public static void main(String[] args) throws InterruptedException {

        int w = 10; // 당구대 너비
        int h = 5;  // 당구대 높이
        int r = 1;  // 당구공 반지름
        int x = 3;  // 초기 x 좌표
        int y = 3;  // 초기 y 좌표
        int dx = 1; // x 방향 속도
        int dy = 1; // y 방향 속도

        while (true) {
            sleep(1000);

            int newX = x + dx;
            int newY = y + dy;


            // CodeA: 공이 당구대의 왼쪽, 오른쪽 벽에 부딪치면
            if (newX - r < 0 || newX + r > w) {
                // CodeB: x축 방향을 바꾼다
                dx = -dx;
            }

            // CodeA: 공이 당구대의 위쪽, 아래쪽 벽에 부딪치면
            if (newY - r < 0 || newY + r > h) {
                // CodeB: y축 방향을 바꾼다
                dy = -dy;
            }

            x = newX;
            y = newY;
        }
    }
}
