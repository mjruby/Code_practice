package leetcode;
//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
//
//设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
//
//你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
//示例:
//
//输入: [1,2,3,0,2]
//输出: 3
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
public class 最佳买卖股票时机含冷冻期 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit1(prices));
    }

    public static int maxProfit(int[] prices) {
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        int pre = 0;
        for (int i = 0; i < prices.length; i++) {
            int tmp = dp_i_0;  // ****
            dp_i_0 = Math.max(dp_i_0, dp_i_1+prices[i]);
            dp_i_1 = Math.max(dp_i_1, pre - prices[i]);
            pre = tmp;  // ***** 冷冻一次处理
        }
        return dp_i_0;
    }

    public static int maxProfit1(int[] prices) {
        int[][] dp = new int[prices.length+1][2];
        // base cases
        dp[0][0] = 0;dp[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i <= prices.length; i++) {
            if(i == 1) {
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i-1]);
                dp[i][1] = Math.max(dp[i-1][1], -prices[i-1]);
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i-1]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0] - prices[i-1]);
        }
        return dp[prices.length][0];
    }
}
