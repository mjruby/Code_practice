package primary.courseeight.selfcode;
// 求n!的结果 f(n) = n * f(n-1)
public class Factorial {

    // 递归
    public static int factorial(int n){
        if(n == 1)
            return 1;
        return n * factorial(n-1);
    }

    // 非递归
    public static int f(int n){
        int res = 1;
        for (int i = n; n > 0; n--) {
            res = res * n;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println("递归 -- 阶乘的结果是："+factorial(n));
        System.out.println("非递归 -- 阶乘的结果是："+f(n));

    }
}
