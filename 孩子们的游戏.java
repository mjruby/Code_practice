package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 孩子们的游戏 {
    public static void main(String[] args) {
        int n = 4,m=3;
        System.out.println(LastRemaining_Solution(n,m));
    }

    public static int LastRemaining_Solution1(int n, int m) {
        if(n < 1) return -1;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(i);
        }

        while(q.size() != 1){
            for (int i = 0; i < m-1; i++) {
                q.add(q.poll());
            }
            q.poll();  // 数到m-1的小孩退出游戏
        }
        return q.poll();
    }

    // other: 使用List存放数据（孩子编号），游标cur,找到第m-1个孩子
    public static int LastRemaining_Solution(int n, int m) {
        if(n<1) return -1;
        ArrayList<Integer> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ls.add(i);
        }
        int cur = -1;  // 【关键】
        while(ls.size()>1){
            for (int i = 0; i < m; i++) {
                cur++;  // 【cur == m-1时，结束本次for循环】
                if(cur == ls.size()){
                    cur = 0;
                }
            }
            ls.remove(cur);
            cur--;  // 【关键：cur位置移除了，cur移动到前一位】
        }
        return ls.get(0);
    }
}
