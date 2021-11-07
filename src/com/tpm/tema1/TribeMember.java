package com.tpm.tema1;

public class TribeMember implements Runnable {

    private final RationsResourcePool rationsResourcePool;
    private final boolean isCook;
    private boolean isDone;

    TribeMember(RationsResourcePool rationsResourcePool, boolean isCook) {
        this.rationsResourcePool = rationsResourcePool;
        this.isCook = isCook;
    }

    @Override
    public void run() {
        while(!isDone) {
            Ration ration = rationsResourcePool.getRation();

                if(isCook){
                    System.out.println("Cook is cooking");
                    try {
                        ration.cook();
                    } finally {
                        exit();
                    }
                }
                else {
                try {
                    ration.eat();
                } finally {
                    exit();
                }
            }
        }
    }
    
    private void exit(){
        isDone = true;
    }
}
