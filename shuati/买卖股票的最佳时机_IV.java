package leetcode;
// 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
//
//设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
//
//注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//示例 1:
//
//输入: [2,4,1], k = 2
//输出: 2
//解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。

// 4
//[1,2,4,2,5,7,2,4,9,0]  -- 15
public class 买卖股票的最佳时机_IV {
    public static void main(String[] args) {
        int[] prices = {1,2,4,2,5,7,2,4,9,0};
        int k = 4;
        System.out.println(maxProfit(k,prices));
        System.out.println(maxProfit1(k,prices));
    }


    // 直接这样会超出内存限制
    public static int maxProfit(int max_k, int[] prices) {
        int[][][] dp = new int[prices.length+1][max_k+1][2];
        if(max_k > prices.length / 2) return maxProfit(prices);
        // base case  所有的 max_k 都要赋值;
        for (int i = max_k; i>= 0; i--) {
            dp[0][i][0] = 0;
            dp[0][i][1] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= prices.length; i++) {  // 这里开始的设置，影响后面的prices
            for (int k = max_k; k >= 1; k--) {
                dp[i][k][0] = Math.max(dp[i-1][k][0],dp[i-1][k][1] + prices[i-1]);
                dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k-1][0] - prices[i-1]);
            }
        }
        return dp[prices.length][max_k][0];
    }

    // 内存限制 解决
    public static int maxProfit1(int max_k, int[] prices) {
        if(max_k > prices.length / 2) return maxProfit(prices);
        int[] dp0 = new int[max_k+1];
        int[] dp1 = new int[max_k+1];
        for (int i = max_k; i>= 0; i--) {
            dp0[i] = 0;
            dp1[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < prices.length; i++) {
            for (int k = max_k; k >= 1; k--) {
                dp0[k] = Math.max(dp0[k],dp1[k] + prices[i]);
                dp1[k] = Math.max(dp1[k],dp0[k-1] - prices[i]);
            }
        }
        return dp0[max_k];
    }


    // k = INF
    public static int maxProfit(int[] prices) {
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0,dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1,tmp - prices[i]);
        }
        return dp_i_0;
    }
}
