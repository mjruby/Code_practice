package offer;
// 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

//【短路原理】： a && b,若a为0则不执行b;
//              a || b 若a为1则不执行b.
public class 求1加2加3加n {
    public static void main(String[] args) {
        System.out.println(Sum_Solution(6));
    }

    public static int Sum_Solution(int n) {
        int sum = n;
        boolean b = (sum>0) && ((sum += Sum_Solution(n-1))>0);
        return sum;
    }
}
