package offer;
// 给定一个double类型的浮点数base和int类型的整数exponent。
// 求base的exponent次方。
//
//保证base和exponent不同时为0
public class 数值的整数次方 {
    public static void main(String[] args) {
        System.out.println(Power(2,-3));
    }

    public static double Power(double base, int exponent) {
        if(base == 0) return 0;  // *
        if(exponent == 0) return 1;
        boolean isZ = true;
        if(exponent < 0) {
            isZ = !isZ;
            exponent = - exponent;
        };
        double res = 1;
        while( exponent>0){
            exponent--;
            res *= base;
        }
        return isZ? res:1/res;
    }
}
