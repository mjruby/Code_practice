package leetcode;
// 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。
// 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
//请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
//说明:
//不允许旋转信封。

//输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出: 3
//解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。

import java.util.Arrays;
import java.util.Comparator;

public class 俄罗斯套娃信封问题 {
    public static void main(String[] args) {
//        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        int[][] envelopes = {};
        System.out.println(maxEnvelopes(envelopes));
    }

    public static int maxEnvelopes(int[][] envelopes) {
        // 排序 --- 按宽升序,相同则按高降序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1]-o1[1] : o1[0]-o2[0];
            }
        });

        // 高 组成的数组
        int len = envelopes.length;
        int[] height = new int[len];
        for (int i = 0; i < len; i++) {
            height[i] = envelopes[i][1];
        }

        // LIS
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if(height[i] > height[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }

        // 找dp[i] 的最大值
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
