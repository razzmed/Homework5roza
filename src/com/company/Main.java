package com.company;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore sem = new Semaphore(4, true);
        for (int i = 1; i < 101; i++) {
            new Passenger(sem, i).start();
        }
    }
}
