package demo;
//我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
//
//        如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
//
//        现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？


import java.util.Scanner;

// 思路：包含 2 5 6 9 中任意一个且不包含 3 4 7 的就是好数
// str.contains()


// 100 -- 40    复杂运算括号的重要性 ！！！
public class X好数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            String str = String.valueOf(i);
            if((str.contains("2") || str.contains("5")|| str.contains("6")|| str.contains("9"))
                && (!str.contains("3") && !str.contains("4")&& !str.contains("7"))){
                count++;
            }
        }
        System.out.println(count);
    }
}

//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int count = 0;
//        for (int i = 1; i <= n; i++) {
//            String str = String.valueOf(i);
//            // 包含2、5、6、9中任意个，且不包含3、4、7的即为好数
//            if ((str.contains("2") || str.contains("5") || str.contains("6") || str.contains("9")) && (!str.contains("3") && !str.contains("4") && !str.contains("7"))) {
//                count++;
//            }
//        }
//        System.out.println(count);
//    }
//}
