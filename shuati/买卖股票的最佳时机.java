package leetcode;
// 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//
//如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
//
//注意：你不能在买入股票前卖出股票。

public class 买卖股票的最佳时机 {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
//        int[] prices = new int[]{1,2,3,4,5};
        System.out.println(maxProfit1(prices));
        System.out.println(maxProfit2(prices));
    }

    // 简便的 空间复杂度 O(1)
    public static int maxProfit(int[] prices) {
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dp_i_0 = Math.max(dp_i_0,dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1,-prices[i]);
        }
        return dp_i_0;
    }

    // 空间复杂度 O(n)
    public static int maxProfit1(int[] prices) {
        if(prices.length == 0 || prices == null) return 0;
        int[][] dp = new int[prices.length][2];

        for (int i = 0; i < prices.length; i++) {
            if(i == 0){
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
            }else {
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
//                dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);  // 错误：一次买卖，这样写是不对的
                dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
            }
        }
        return dp[prices.length - 1][0];
    }

    // 空间复杂度 O(n) 自己变形
    public static int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length+1][2];

        dp[0][0] = 0 ; dp[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i <= prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i-1]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i-1]);
        }
        return dp[prices.length][0];
    }
}
