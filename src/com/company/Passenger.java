package com.company;

import java.util.concurrent.Semaphore;

public class Passenger extends Thread{
    Semaphore semaphore;
    int passNumber;

    public Passenger(Semaphore semaphore, int passNumber) {
        this.semaphore = semaphore;
        this.passNumber = passNumber;
    }
    @Override
    public synchronized void run(){
        try {
            semaphore.acquire();
            System.out.println("Пассажир " + passNumber + " покупает в кассе");
            sleep(1000);
            System.out.println("Пассажир " + passNumber + " идет на посадку");
            semaphore.release();
            sleep(1000);
        } catch (InterruptedException e){
            System.out.println("Пассажир отказался от поездки");
        }
    }
}
