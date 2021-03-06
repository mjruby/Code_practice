package leetcode;
// 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
//搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
//你可以假设数组中不存在重复的元素。
//你的算法时间复杂度必须是 O(log n) 级别。  -- 二分查找
//示例 1:
//
//输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
//示例 2:
//
//输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1

public class 搜索旋转排序数组 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int[] nums1 = new int[]{6,7,0,1,2,3,4,5};
        int[] nums2 = new int[]{4,5,6,7,0,1,2};

        int target = 3                               ;
        System.out.println(search(nums2,target));
    }
    public static int search(int[] nums, int target) {
        if(nums==null || nums.length == 0) return -1;
        int left = 0 ;
        int right = nums.length-1;
        int mid = left +((right-left)>>1);
        while(left+1 < right){   // 这里判定条件要注意
            if(nums[mid] == target) return mid;
            if(nums[mid] > nums[left]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }else {
                if(target > nums[mid] && target <= nums[right]){
                    left = mid+1;
                }else {
                    right = mid -1;
                }
            }
            mid = left +((right-left)>>1);
        }
        if(nums[left] == target) return left;
        if(nums[right] == target) return right;
        return -1;
    }
}
