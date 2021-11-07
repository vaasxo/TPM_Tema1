package com.tpm.tema1;

public class TribeMember implements Runnable {

    private final RationsResourcePool rationsResourcePool;
    private final boolean isCook;
    private boolean isDone;
    private final int memberNo;

    TribeMember(RationsResourcePool rationsResourcePool, boolean isCook, int memberNo) {
        this.rationsResourcePool = rationsResourcePool;
        this.isCook = isCook;
        this.memberNo = memberNo;
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
                    ration.eat(memberNo);
                } finally {
                    exit();
                }
            }
        }
        return;
    }

    private void exit(){
        isDone = true;
    }
}
