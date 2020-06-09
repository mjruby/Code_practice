package offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//
public class 滑动窗口的最大值 {
    public static void main(String[] args) {
        int[] num = {10,14,12,11}; int size = 0;
        System.out.println(maxInWindows(num,size));
    }

    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> rs = new ArrayList<>();
        if(num.length < size || size == 0) return rs;
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            if(i < size) addNum(dq,num[i]);
            else {
                rs.add(dq.peekFirst());
                addNum(dq,num[i]);
                removeNum(dq,num[i-size]);
            }
        }
        rs.add(dq.peekFirst());
        return rs;
    }

    // 重点
    public static void addNum(Deque<Integer> dp ,Integer val){
        while(!dp.isEmpty() && dp.peekLast() < val) dp.removeLast(); // 6 1 1 5 3 4
        dp.addLast(val);
    }

    public static void removeNum(Deque<Integer> dp ,Integer val){
        if(dp.peekFirst() == val){
            dp.removeFirst();
        }
    }
}
