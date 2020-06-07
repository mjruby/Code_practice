package offer;
// 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
// 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
// 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
public class 剪绳子 {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(new Jianshenzi().cutRope1(num));
    }
}


class Jianshenzi {
    // 解析，分成2.3结果最大
    public int cutRope(int target) {
        // 特例
        if(target == 2) return 1;
        if(target == 3) return 2;

        if(target > 3){
            int n = target / 3;
            int m = target % 3;
            if(m == 0) return (int)Math.pow(3,n);
            if(m == 1) return ((int)Math.pow(3,n-1))*4;
            if(m == 2) return (int)Math.pow(3,n)*2;
        }
        return 0;
    }


    // other people
    public int cutRope1(int target) {
        int res = 1;
       if(target < 4){
           return target -1;
       }else {
           while(target>4){
               target -= 3;
               res *= 3;
           }
           return res*target;
       }
    }

}


