package primary.courseseven.self;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
// 【贪心算法】
//  一块金条切成两半，是需要花费和长度数值一样的铜板的。
//  比如长度为20的金条，不管切成长度多大的两半，都要花费20个铜板。
//  一群人想整分整块金条，怎么分最省铜板？

//  PriorityQueue 创建的队列，会默认把里面的元素安装从小到大排序，每次增加/减少都会自动更新排序
// 想要从大到小排序，自己构造Comparator接口的实体类就行
public class LessMoney {


    public static class compareMaxHeat implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static int lessMoney(int[] arr){
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int num : arr) {
            pQ.add(num);
        }
        int cur = 0;
        int res = 0;
        while(pQ.size() > 1){
            cur = pQ.poll()+pQ.poll();
            res += cur;
            pQ.add(cur);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,3,7};
        System.out.println("最少需要花费："+lessMoney(arr));  // 29

        System.out.println("=========================================");
        System.out.println("下面是探究PriorityQueue用法");
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        for (int i : arr) {
            minPQ.add(i);
        }
        System.out.println(minPQ.poll());
        minPQ.add(4);
        while (!minPQ.isEmpty()){
            System.out.println(minPQ.poll());
        }
        System.out.println("==================");
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(new compareMaxHeat());
        for (int i : arr) {
            maxPQ.add(i);
        }
        while(!maxPQ.isEmpty()){
            System.out.println(maxPQ.poll());
        }
    }

}
