package com.ming.leetcode;

import java.util.HashMap;

public class t1 {

    public static void main(String[] args) {
        System.out.println(8>>1);
    }

    public static int mySqrt(int x) {
        return x>>2;
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])!=null){
                if(nums[i]*2==target){
                    res[0] = map.get(nums[i]);
                    res[1] = i;
                    return res;
                }
                continue;
            }
            map.put(nums[i],i);
        }
        for (int v: nums) {
            int needed = target-v;
            if(needed==v) continue;
            if(map.get(needed)!=null){
                res[0] = map.get(v);
                res[1] = map.get(needed);
                break;
            }
        }
        return res;
    }
}
