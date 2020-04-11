package demo;
//      第一行输入参与漂流的人员对应的体重数组，
//      第二行输入漂流船承载的最大重量
//      所需最小船只数

//  1 2
//  3
//  1

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class piaoliuchuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" ");
        int[] arr = new int[s.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int lim = sc.nextInt();
        int res = lessChuan(arr,lim);
        System.out.println(res);
    }

    public static int lessChuan(int[] arr, int lim){
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length-1;
        int count = 0;
        while(i<j){
            if(arr[i]+arr[j] <= lim){
                count++;i++;j--;
            }else if(arr[j] <= lim){
                count++;j--;
            }else {
                return 0;
            }
        }
        return count + (i==j? 1:0);
    }
}
