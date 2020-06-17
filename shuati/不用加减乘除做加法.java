package offer;
// 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。


// 【重要思路】：异或作加法，与门作进位，当进位为0，结束运算
public class 不用加减乘除做加法 {
    public static void main(String[] args) {
        int nm1 = 33;
        int nm2 = 44;
        System.out.println(Add(nm1,nm2));
    }

    public static int Add(int num1,int num2) {
        int res = 0;int carry = 0;
        do{
            res = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = res;
            num2 = carry;
        }while (carry != 0);
        return res;
    }
}
