package offer;
// 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
// 求该青蛙跳上一个n级的台阶总共有多少种跳法。
public class 变态跳台阶 {

    public static void main(String[] args) {
        System.out.println(JumpFloorII1(3));
    }

    public static int JumpFloorII(int target) {
        if(target<=2) return target;
        int[] dp = new int[target+1];
        dp[1] = 1;
        dp[2] = 2;
        int res = dp[1];
        for (int i = 3; i <= target; i++) {
            dp[i] = sum(dp,1,i-1)+1;

        }
        return dp[target];
    }

    public static int sum(int[] dp,int start,int end){
        int res = 0;
        for (int i = start; i <= end; i++) {
            res+=dp[i];
        }
        return res;
    }


    // other: 总结规律：f(n) = 2f(n-1)
    public static int JumpFloorII1(int target) {
        if(target <=1) return target;
        int res = 1;
        for (int i = 2; i <= target; i++) {
            res = 2*res;
        }
        return res;
    }
}
