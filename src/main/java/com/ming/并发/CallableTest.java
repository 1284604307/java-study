package com.ming.并发;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws Exception {

        Callable<Boolean> taskWater = () -> {
            System.out.println("开始烧水");
            Thread.sleep(1000);
            System.out.println("水好了");
            return true;
        };
        FutureTask<Boolean> tw = new FutureTask<>(taskWater);
        Callable<String> taskTea = () -> {
            if(tw.get()){
                System.out.println("开始沏茶");
                Thread.sleep(2000);
                System.out.println("茶好了");
                return "龙井";
            }else{
                return "水还没好";
            }
        };
        FutureTask<String> tt = new FutureTask<>(taskTea);
        new Thread(tw).start();
        new Thread(tt).start();
        System.out.println(tt.get());
    }
}
