package com.ming.集合;

import java.util.HashMap;

public class HMap {
    public static void main(String[] args) {
        HashMap<String, Object> objects = new HashMap<>();
        objects.put(null,null);
        objects.forEach((k,v)->{
            System.out.println(v);
        });
    }
}
