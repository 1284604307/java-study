package com.ming;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.stream.Collectors;


public class TestCompletableFuture {

    public static void main(String[] args) {
        new TestCompletableFuture().getPriceAsync("");
    }

    private double calculatePrice(String p){
        return 12.2;
    }


    public Future<Double> getPriceAsync(final String product) {

        final CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            double price = calculatePrice(product);
            futurePrice.complete(price);  //完成后使用complete方法，设置future的返回值
        }).start();
        return futurePrice;
    }

}
