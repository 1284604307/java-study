package com.ming.面试;

public class test {
    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("222222");
            }
        });
        t1.start();
        t1.join();
        System.out.println("1111");
    }
}
