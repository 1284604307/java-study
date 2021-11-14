package com.ming;

import com.google.common.primitives.SignedBytes;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        int i = 2;
        t.test(i);

    }
    //局部final变量 a，b
    public void  test(final int b){
        final int a = 1 ;
        //匿名内部类
        new Thread(){
            public void run(){
                System.out.println(a);
                System.out.println(b);
            }
        }.start();
        OutClass o = new OutClass();

        o.test(a);
    }
}

class OutClass{
    private int v = 12;
    public void test(final int x){
        class InClass{
            public void print(){
                System.out.println(x);
                System.out.println(v);
            }
        }
        new InClass().print();
    }
}
