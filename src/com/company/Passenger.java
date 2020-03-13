package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Passenger extends Thread {
    private Semaphore semaphore;
    private int passNumber;
    private CountDownLatch cdl;

    public Passenger(Semaphore semaphore, int passNumber, CountDownLatch cdl) {
        this.semaphore = semaphore;
        this.passNumber = passNumber;
        this.cdl = cdl;
    }

    @Override
    public synchronized void run() {
        try {
            semaphore.acquire();
            System.out.println("Пассажир " + passNumber + " покупает в кассе");
            sleep(1000);
            System.out.println("Пассажир " + passNumber + " идет на посадку");
            semaphore.release();
            sleep(1000);
            System.out.println("Пассажир " + passNumber + " занял свое место");
            cdl.countDown();
        } catch (InterruptedException e) {

        }
    }
}
