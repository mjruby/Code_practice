package demo;
//假设你正在玩跳格子（所有格子排成一个纵列）游戏。需要 跳完n 个格子你才能抵达终点。
//        每次你可以跳 1 或 2 个格子。你有多少种不同的方法可以到达终点呢？
//        注意：给定 n 是一个正整数。

// 思路：dp[i] = dp[i-1]+dp[i-2]

import java.util.Scanner;

public class 跳格子游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(step(n));
    }

    public static int step(int n){
        if(n == 1) return  1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i =2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

}
