package com.example.algorithm;

public class AsyncExample2 {

    public static void main(String[] args) {

        new Thread(() -> {
            try {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            Thread.sleep(2000);
            System.out.println("메인 스레드 종료");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
