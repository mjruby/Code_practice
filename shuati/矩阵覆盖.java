package offer;

public class 矩阵覆盖 {
    public static void main(String[] args) {
        System.out.println(RectCover(1));
    }

    // 手动画图，可以找到规律：dp[i] = dp[i-1] + dp[i-2]
    public static int RectCover(int target) {
        if(target < 1) return 0;
        int[] dp = new int[target+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[target];
    }
}
