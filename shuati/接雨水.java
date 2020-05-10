package leetcode;
// 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
// 输出: 6
public class 接雨水 {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
        System.out.println(trap1(height));
    }

    // 时间复杂度 O(n) 空间复杂度O(n)
    public static int trap(int[] height) {
        if(height.length<3) return 0;
        int len = height.length;
        int[] l_max = new int[len];
        int[] r_max = new int[len];
        // 左边最大
        l_max[0] = height[0];
        for (int i = 1; i < len - 1; i++) {
            l_max[i] = Math.max(l_max[i-1],height[i]);
        }
        // 右边的最大
        r_max[len -1] = height[len-1];
        for (int i = len-2; i >=0 ; i--) {
            r_max[i] = Math.max(height[i],r_max[i+1]);
        }

        // 雨水计算
        int res = 0;
        for (int i = 1; i < len-1; i++) {
            res += Math.min(r_max[i],l_max[i]) - height[i];  // 这里左边最大值要包括自身，右边最大值也包括自身，
            // 因为可能所求位置的height[i]比它左边或右边的最大还大
        }
        return res;
    }

    // 时间复杂度 O(n) 空间复杂度O(1)
    public static int trap1(int[] height) {
        if(height.length < 3) return 0;
        int l_max = height[0];
        int r_max = height[height.length - 1];
        int left = 1, right = height.length - 2;

        int res = 0;
        while (left <= right){
            l_max = Math.max(l_max,height[left]);
            r_max = Math.max(r_max,height[right]);
            if(l_max < r_max){
               res += l_max - height[left];
               left++;
            }else {
                res += r_max - height[right];
                right--;
            }
        }
        return res;
    }
}
