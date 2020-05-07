package leetcode;
// 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
// 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//示例 1:
//输入: [3,3,5,0,0,3,1,4]
//输出: 6
//解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3。
//
public class 买卖股票的最佳时机_III {
    public static void main(String[] args) {
//        int[] prices = {};
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit1(prices));
    }


    // k = 2; 空间复杂度 O(1)
    public static int maxProfit(int[] prices) {
        int dp_i_2_0 = 0, dp_i_2_1 = Integer.MIN_VALUE;
        int dp_i_1_0 = 0, dp_i_1_1 = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            dp_i_2_0 = Math.max(dp_i_2_0, dp_i_2_1 + prices[i]);
            dp_i_2_1 = Math.max(dp_i_2_1, dp_i_1_0 - prices[i]);
            dp_i_1_0 = Math.max(dp_i_1_0, dp_i_1_1 + prices[i]);
            dp_i_1_1 = Math.max(dp_i_1_1,  - prices[i]);
        }
        return dp_i_2_0;
    }

    // k = 2; 空间复杂度 O(n)
    public static int maxProfit1(int[] prices) {
        int max_k = 2;
        int[][][] dp = new int[prices.length+1][max_k+1][2];
        // base case;
        dp[0][max_k][0] = 0; dp[0][max_k][1] = Integer.MIN_VALUE;
        dp[0][max_k-1][0] = 0; dp[0][max_k-1][1] = Integer.MIN_VALUE;
        dp[0][0][0] = 0; dp[0][0][1] = Integer.MIN_VALUE;
        for (int i = 1; i <= prices.length; i++) {  // 这里开始的设置，影响后面的prices
            for (int k = max_k; k >= 1; k--) {
                dp[i][k][0] = Math.max(dp[i-1][k][0],dp[i-1][k][1] + prices[i-1]);
                dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k-1][0] - prices[i-1]);
            }
        }
        return dp[prices.length][max_k][0];
    }
}

