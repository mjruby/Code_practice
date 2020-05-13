package leetcode;
// 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
// 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//
//返回滑动窗口中的最大值。

// 思；双端队列，Deque 操作需要注意
// Queue<Integer> cur_res = new LinkedList<>();
import java.util.*;

public class 滑动窗口的最大值 {
    public static void main(String[] args) {
        int[] nums = new int[]{7,2,4};
        int k = 2;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length < k) return new int[]{};
        int[] res = new int[nums.length - (k-1)];
        int idx = 0;

        MyQueue q = new MyQueue();
        int left = 0;
        int right = 0;
        for (right = 0; right < nums.length; right++) {
            if (right < k) {
                q.add(nums[right]);
            } else {
                res[idx++] = q.maxVal();
                q.remove(nums[left++]);
                q.add(nums[right]);
            }
        }
        res[idx] = q.maxVal();
        return res;
    }
}

class MyQueue{
    Deque<Integer> queue = new LinkedList<>();   // 双端队列

    public void add(int val){
        if(queue.isEmpty()){
            queue.add(val);
        }else{
            if(val > queue.peekFirst()){
                queue.clear();
                queue.add(val);
            }else {
                queue.add(val);
            }
        }
    }

    public void remove(int val){
        if(queue.peekFirst() == val){
            queue.removeFirst();

            // 调整 剩余最大的放第一位
            Deque<Integer> tmp = new LinkedList<>();
            tmp.add(queue.pollFirst());
            while(!queue.isEmpty()){
                Integer cur = queue.pollFirst();
                if(tmp.peekFirst() < cur){
                    tmp.addFirst(cur);
                }else {
                    tmp.addLast(cur);
                }
            }
            queue = tmp;
        }
    }

    public int maxVal(){
        return queue.peekFirst();
    }
}


