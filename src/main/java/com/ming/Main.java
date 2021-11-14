package com.ming;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class Main {

    static Random random = new Random();
    private static  int i = 1;

    private static synchronized void add(int o){
        System.out.println(Thread.currentThread().getName()+":入>>>"+i+" <<<"+(i+o));
        int m = i;
        try {
            Thread.sleep(500+o* 10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i = o+m;
        System.out.println(Thread.currentThread().getName()+"<<<"+i);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class updateT extends Thread{
        int o;
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
    public static void main(String[] args) throws IOException {
        new updateT(-1).start();
        new updateT(10).start();
        TestFileUntil("","");
    }
    static void TestFileUntil(String a,String b) throws IOException {
        FileUtils.copyURLToFile(new URL(a),new File(b));
    }
}
