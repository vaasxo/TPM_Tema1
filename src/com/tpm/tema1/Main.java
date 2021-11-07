package com.tpm.tema1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        final int TribeMembers = 10;
        final int AvailableRations = 5;

        final ExecutorService executorService = Executors.newFixedThreadPool(TribeMembers);

        final RationsResourcePool rationsResourcePool = new RationsResourcePool(AvailableRations);

        for (int i = 0; i < TribeMembers-1; i++) {
            executorService.submit(new TribeMember(rationsResourcePool, false));
        }
        executorService.submit(new TribeMember(rationsResourcePool,true));
    }
}
