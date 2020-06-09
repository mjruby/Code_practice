package offer;

import java.awt.*;
import java.util.Comparator;
import java.util.PriorityQueue;

// 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
public class 数据流中的中位数 {
    static Myclass q = new Myclass();
    public static void main(String[] args) {
        Insert(1);
        Insert(2);
        Insert(3);
        System.out.println(GetMedian());
        Insert(4);
        Double val = GetMedian();
        System.out.println(val);
    }

    public static void Insert(Integer num) {
        if(!q.pmin.isEmpty() && num > q.pmin.peek()) q.pmin.add(num);
        else q.pmax.add(num);
        int size_max = q.pmax.size();
        int size_min = q.pmin.size();
        if(size_max - size_min > 1){
            q.pmin.add(q.pmax.remove());
        }
        if(size_min - size_max > 1){
            q.pmax.add(q.pmin.remove());
        }
    }

    public static Double GetMedian() {
        int size_max = q.pmax.size();
        int size_min = q.pmin.size();
        double res = 0 ;
        if((size_max+size_min)%2 == 1) {
            res = size_max > size_min?(double)q.pmax.peek():(double)q.pmin.peek();
        } else {
            res = (q.pmax.peek() + q.pmin.peek())/2.0;
        }
        return res;
    }
}

class Myclass{
//    // 排序 从大到小
//    class compareMax implements Comparator<Integer>{
//        @Override
//        public int compare(Integer o1, Integer o2) {
//            return o2 - o1;
//        }
//    }
//
//    class compareMin implements Comparator<Integer>{
//        @Override
//        public int compare(Integer o1, Integer o2) {
//            return o1 - o2 ;
//        }
//    }
//  PriorityQueue<Integer> pmax = new PriorityQueue<>(new compareMax()); // 大根堆
//    PriorityQueue<Integer> pmin = new PriorityQueue<>(new compareMin()); // 小根堆

    PriorityQueue<Integer> pmax = new PriorityQueue<>((o1, o2) -> o2-o1); // 成功使用lamba表达式
    PriorityQueue<Integer> pmin = new PriorityQueue<>((o1, o2) -> o1-o2);
}

