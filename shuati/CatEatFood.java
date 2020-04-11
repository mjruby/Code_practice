package demo;

// 返回她可以在 H 小时内吃掉所有喵粮的最小速度 K（K 为整数）。
//  3 6 7 11
//        8

// 4

import java.util.Arrays;
import java.util.Scanner;

public class CatEatFood {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str1 = sc.nextLine();
//        int h = sc.nextInt();

        String str1 = "3";
        int h = 1;

        String[] s = str1.split(" ");
        int total = 0;
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
            total += arr[i];
        }

        int k = total / h;  // 每个小时最少的食量

        while (true) {
            int sum = 0;
            for (int num : arr) {
                sum += (num + k - 1) / k;  // 上取整
            }
            if (sum == h) {
                break;
            }
            k++;
        }
        System.out.println(k);

    }
}
