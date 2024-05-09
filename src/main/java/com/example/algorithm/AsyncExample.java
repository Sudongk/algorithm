package com.example.algorithm;

public class AsyncExample {

    public static void main(String[] args) {
        // 비동기인데 왜 순차적으로 실행되는 이유 -> 메인 스레드가 종료되면 프로그램이 종료되기 때문
        // 같은 스레드라서 순차적으로 실행되는거 같은데 맞아? -> 맞아

        try {
            System.out.println("첫 번째 작업");
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("두 번째 작업");
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
