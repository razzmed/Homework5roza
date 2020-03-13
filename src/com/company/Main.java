package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {
    public static final int Passenger = 100;

    public static void main(String[] args) throws InterruptedException {

        Semaphore sem = new Semaphore(4, true);
        CountDownLatch latch = new CountDownLatch(100);


        for (int j = 1; j <= 100; j++) {
            new Passenger(sem, j, latch).start();


        }
        try {
            latch.await();
            System.out.println("Все пассажиры заняли свои места в автобусе");
            System.out.println("Поехали!");
        } catch (InterruptedException e) {}
    }
}
