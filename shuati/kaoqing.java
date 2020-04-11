package demo;
// 给定一个字符串来代表一个员工的考勤纪录，这个纪录仅包含以下两个字符：
//        'A' : Absent，缺勤
//        'P' : Present，到场
//        如果一个员工的考勤纪录中不超过两个'A'(缺勤),那么这个员工会被奖赏。
//
//        如果你作为一个员工，想在连续N天的考勤周期中获得奖赏，请问有多少种考勤的组合能够满足要求

import java.util.Scanner;

// 3
// 7
public class kaoqing {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int total = 0;
        total = jcheng(n,1)+jcheng(n,2)+1;
        System.out.println(jcheng(10,6));
        System.out.println(jcheng(5,3));
        System.out.println(total);
    }

    public static int jcheng(int a , int b) {   // 只是对底数是1/2有效，因为实际下面是n!
        int c = a - b;
        int times = Math.max(c, b);
        int sum = 1;
        while (a > times) {
            sum = sum * a;
            a--;
        }
        return sum/Math.min(c,b);
    }
}





// 别人的
//public class Main{
//    public static void main(String[] args){
//        Scanner input = new Scanner(System.in);
//        int len = input.nextInt();
//        if (len == 1)
//            System.out.println(1);
//        else if (len == 2)
//            System.out.println(4);
//        else{
//            System.out.println(len*(len-1)/2+len+1);
//        }
//    }
//}