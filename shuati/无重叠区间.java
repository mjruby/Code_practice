package leetcode;
// 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。

import java.util.Arrays;
import java.util.Comparator;

//可以认为区间的终点总是大于它的起点。
//区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
// [ [1,2], [2,3], [3,4], [1,3] ]
public class 无重叠区间 {
    public static void main(String[] args) {
//        int[][] intervals = new int[][]{{1,2},
//                {2,3},
//                {3,4},
//                {1,3}};
        int[][] intervals = {{1,2}, {1,2}, {1,2}};

        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals== null || intervals.length==0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {  // 按结束从小到大
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        // 最多有多少个不相交区间
        int time_end = intervals[0][1];
        int count = 1 ;
        for (int[] interval : intervals) {
            if(interval[0] >= time_end){
                time_end = interval[1];
                count++;
            }
        }
        return intervals.length - count;
    }
}
