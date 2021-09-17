package com.ming;

import java.util.Random;

public class Main {
    static Random random = new Random();
    private static int i = 1;

    private static  int get(){
        return i;
    }

    private static synchronized void add(int o){

        try {
            int t = random.nextInt(100);
//                    System.out.println("延迟"+t);
            Thread.sleep(300+10*t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int m = get();
        System.out.println(Thread.currentThread().getName()+":>>>"+m);
        m += o;

        try {
            int t = random.nextInt(100);
//                    System.out.println("模拟耗时操作"+t);
            Thread.sleep(300+10*t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        set(m);
        System.out.println(Thread.currentThread().getName()+":<<<"+m);
        try {
//                    System.out.println("模拟耗时操作"+t);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static  void  set(int io){
        i = io;
    }
    static class updateT extends Thread{
        int o = 1;
        updateT(int i) {
            this.o = i;
        }

        @Override
        public void run() {
            while (i<1000){
                add(o);
            }
        }
    }
    public static void main(String[] args) {

        new updateT(1).start();
        new updateT(55).start();
        new updateT(1).start();
        new updateT(1).start();
    }
}
