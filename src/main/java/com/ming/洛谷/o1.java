package com.ming.洛谷;

import java.util.Scanner;

public class o1 {
    public static void main(String[] args) throws Exception {
        int runN = 0;
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(),n=sc.nextInt();
        int x0 = sc.nextInt()-1;
        int y0 = sc.nextInt()-1;
        System.out.println("初始位置为 "+x0+","+y0);
        P[][] ps = new P[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ps[i][j] = new P(i,j,sc.nextInt());
            }
        }

        for (P[] p : ps) {
            for (P p1 : p) {
                System.out.print(p1.high+" ");
            }
            System.out.println();
        }

        int fly = 0;
        int d = 0;
        P curP = ps[x0][y0];
        curP.isInit = true;
        do {
            System.out.println("from : "+curP);
            R r = nextBetter(curP, ps,runN);
            curP = r.p;
            curP.isRun = true;
            if(r.isFly){
                System.out.println("飞行 "+r.distance);
                fly++;
                d+=r.distance;
            }
            System.out.println("to : "+curP);

            for (P[] p : ps) {
                for (P p1 : p) {
                    System.out.print(p1.isRun+" ");
                }
                System.out.println();
            }
            runN++;
        } while (!curP.isInit);

        System.out.println(fly);
        System.out.println(d);

//        3 3 1 1
//        1 2 3
//        8 9 4
//        7 6 5

    }

    static boolean canJump(P p0,P p1){
        if(p1.isRun) return false;
        int i = p0.high - p1.high;
        return i == 1;
    }

    static int distance(P p0,P p1){
        return p1.high - p0.high;
    }

    static R nextBetter(P p,P[][] arr,int runN) throws Exception {
        // 先判断四个方向有没有直接跳跃 且 没有走过的点
        // 左边
        if (p.x!=0 && canJump(p,arr[p.y][p.x-1])) {
            return new R( arr[p.y][p.x-1]);
        }
        // ex 上边
        if (p.y!=0 && canJump(p,arr[p.y-1][p.x])) {
            return new R( arr[p.y-1][p.x]);
        }
        // 右边
        if (p.x!= arr.length-1 && canJump(p,arr[p.y][p.x+1])) {
            return new R( arr[p.y][p.x+1]);
        }
        // 下边
        if (p.y!=arr[0].length-1 && canJump(p,arr[p.y+1][p.x])) {
            return new R( arr[p.y+1][p.x]);
        }

        // 行循环
        P rp = p;
        int d = Integer.MAX_VALUE;
        for (P[] ps : arr) {
            for (P p1 : ps) {
                if(p1.isRun) continue;
                if(p1.isInit && runN<arr.length*arr[0].length-1) continue;
                int nd = distance(p,p1);
//                nd = Math.abs(nd);
                if(d==Integer.MAX_VALUE){
                    d = nd;
                    rp = p1;
                }
                if(nd>d){
                    d = nd;
                    rp = p1;
                }
            }
        }

        if(rp == p) throw new Exception("error");
        R r = new R(rp, true);
        r.distance = d;
        return r;
    }

    static class R{
        P p;
        int distance;
        boolean isFly = false;

        public R(P p, boolean isFly) {
            this.p = p;
            this.isFly = isFly;
        }
        public R(P p) {
            this.p = p;
        }
    }

    static class P{
        @Override
        public String toString() {
            return "P{" +
                    "x=" + x +
                    ", y=" + y +
                    ", high=" + high +
                    '}';
        }

        int x;
        int y;
        int high;
        boolean isInit = false;
        boolean isRun = false;

        public P(int y, int x, int high) {
            this.x = x;
            this.y = y;
            this.high = high;
        }
    }


}
