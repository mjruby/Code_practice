package leetcode;
// 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
//传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。
// 我们装载的重量不会超过船的最大运载重量。
//
//返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
//输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
//输出：15
//解释：
//船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
//第 1 天：1, 2, 3, 4, 5
//第 2 天：6, 7
//第 3 天：8
//第 4 天：9
//第 5 天：10

import static leetcode.爱吃香蕉的珂珂.maxVal;

public class 在D天内送达包裹的能力 {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int D = 5;
        System.out.println(shipWithinDays(weights,D));
    }

    public static int shipWithinDays(int[] weights, int D) {
        int left = max_Val(weights);
        int right = sum_Val(weights) + 1;
        while(left < right){
            int mid = left + ((right - left) >> 1);
            if(is_Match(weights,mid,D)){
                right = mid;
            }else {
                left = left + 1;
            }
        }
        return left;
    }

    private static boolean is_Match(int[] weights, int load, int d) {
        int maxLoad = load;
        for (int weight : weights) {
            if(load - weight >= 0){
                load = load - weight;
            }else {
                d--;
                if(d > 0){
                    load = maxLoad - weight;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    private static int sum_Val(int[] weights) {
        int res = 0;
        for (int weight : weights) {
            res += weight;
        }
        return res;
    }

    private static int max_Val(int[] weights) {
        int res = 0;
        for (int weight : weights) {
            res = Math.max(weight, res);
        }
        return res;
    }


}
