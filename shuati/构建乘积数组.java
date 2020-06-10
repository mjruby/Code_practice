package offer;

import java.util.Arrays;
// 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
public class 构建乘积数组 {
    public static void main(String[] args) {

        int[]  a = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(a));
        int[] b = multiply(a);
        System.out.println(Arrays.toString(b));

    }
    public static int[] multiply(int[] A) {
        int len = A.length;
        int[] b = new int[len];
        int tmp = 1;
        for (int i = 0; i < len; i++) {
            b[i] = tmp;
            tmp *= A[i];
        }
        tmp = 1;
        for (int i = len-1; i >=0; i--) {
            b[i] *= tmp;
            tmp *= A[i];
        }
        return b;
    }
}
