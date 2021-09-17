package com.ming;

public class volatile_synchronized {
    public static void main(String[] args) {
        new noSee().start();
        while (unSeeNumber<10){
            try {
                Thread.sleep(300);
                System.out.println(getUnSeeNumber());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("stop");
    }

    static int unSeeNumber = 0;

    public static void addUnSeeNumber(){
        unSeeNumber++;
    }

    public static int getUnSeeNumber(){
        return unSeeNumber;
    }

}

class noSee extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            try {
                Thread.sleep(500);
                volatile_synchronized.addUnSeeNumber();
                System.out.println("unSeeNumber++,"+ volatile_synchronized.unSeeNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}