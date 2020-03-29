package primary.courseeight.selfcode;
//  母牛每年生一只母牛，新出生的母牛成长三年后也能每年生一只母牛，假设不会死。
//  求N年后，母牛的数量。

// 如果每只母牛只能活10年，求N年后，母牛的数量。
// 是个问题 ？？

// f(n) = f(n-1) + f(n-3)
public class Cow {
    public static int sumCow(int n){
        if(n < 5) return n;
        return sumCow(n-1)+sumCow(n-3);
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("第 "+n+" 年的牛总数为："+ sumCow(n));
    }
}
