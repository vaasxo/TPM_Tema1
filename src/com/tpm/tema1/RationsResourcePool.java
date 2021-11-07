package com.tpm.tema1;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class RationsResourcePool {

    private final int rationCapacity;
    private final ConcurrentLinkedQueue availableRations;
    private final Semaphore semaphore;

    public RationsResourcePool(int numberOfRations) {

        availableRations = new ConcurrentLinkedQueue();
        rationCapacity = numberOfRations;

        for (int i = 0; i < rationCapacity; i++) {
            Ration currentRation = new Ration();
            availableRations.add(currentRation);
        }
        semaphore = new Semaphore(numberOfRations);
    }

    public Ration getRation() {

        // System.out.println("\n\n number of rations" + availableRations.toString() + "\n\n");

        try {
            semaphore.acquire();
            if (availableRations.isEmpty()) {
                cook();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
        return (Ration) availableRations.poll();
    }

    public void cook() {
        for (int i = 0; i < rationCapacity; i++) {
            Ration currentRation = new Ration();
            availableRations.add(currentRation);
        }
    }
}
