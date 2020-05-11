package leetcode;
// 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
//
//珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。
// 如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
//
//珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
//
//返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。

// 输入: piles = [3,6,7,11], H = 8
// 输出: 4
public class 爱吃香蕉的珂珂 {
    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        int H = 6;
        System.out.println(minEatingSpeed(piles,H));
    }

    // 使用二分查找，优化线性查找
    public static int minEatingSpeed(int[] piles, int H) {
        if(piles.length > H) return 0;
        int left = 1;
        int right = maxVal(piles)+1;

        while(left < right){
            int mid = left + ((right - left) >> 1);
            if(isMatch(piles,mid,H)){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean isMatch(int[] piles, int speed, int h) {
        int total = 0;
        for (int pile : piles) {
            total += pile / speed + (pile % speed == 0 ? 0 : 1); // ***
        }
        return total <= h;
    }

    public static int maxVal(int[] piles){
        int res = 0;
        for (int pile : piles) {
            res = Math.max(res,pile);
        }
        return res;
    }
}
