package leetcode;
// 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
//
//返回被除数 dividend 除以除数 divisor 得到的商。
public class 两数相除 {
    public static void main(String[] args) {
        int n = 10;
        while(n-->=0){
            int num1 = (int)(Math.random()*30);
            int num2 = (int)(Math.random()*8);
            System.out.println(num1+" "+num2);
            System.out.println(divide(num1,num2));
            System.out.println("============================");
        }

    }

    public static int divide(int dividend, int divisor) {
        if(divisor == 0) return 0;
        if(dividend == Integer.MIN_VALUE && divisor == 1) return dividend;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        long did = dividend;
        long dis = divisor;
        int flag = 1;
        if(did < 0){
            flag = -flag;
            did = -did;
        }
        if(dis < 0 ){
            flag = -flag;
            dis = -dis;
        }
        int shift = 0;
        long res = 0;
        while (did >= dis){
            shift = 0;
            while((dis << shift) <= did){
                shift++;
            }
            did = did - (dis << (shift-1));
//            res = (dis << (shift-1))+res; // 移动0，就是dis本身
            res = res + (1 << (shift-1));
        }
        return (int)res*flag;
    }
}
