package leetcode;
// 给出一个区间的集合，请合并所有重叠的区间。
//
//示例 1:
//
//输入: [[1,3],[2,6],[8,10],[15,18]]
////输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].


// 知识点
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 合并区间 {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
//        int[][] intervals = {{1,4},{0,4}};
        int[][] res = merge1(intervals);

        printArrs(res);

    }

    // 打印二维数组
    public static void printArrs(int[][] arr){
        if(arr == null || arr.length == 0) return;
        int nrow = arr.length;
        int ncol = arr[0].length;
        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    // 自己的
    public static int[][] merge(int[][] intervals) {
        List<Integer> ls = new ArrayList<>();
        if(intervals == null || intervals.length == 0) return new int[][]{};
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int start = intervals[0][0];
        int end = intervals[0][1]; int res_end = 0;
        for (int i = 1; i < intervals.length;) {
            if(intervals[i][0] <= end){
                end = Math.max(intervals[i][1],end);
                i++;
            }else{
                ls.add(start);
                ls.add(end);
                start = intervals[i][0];
                end = intervals[i][1];
                i++;
            }
        }
        ls.add(start);
        ls.add(end);
        int len = ls.size()/2;
        int[][] res = new int[len][2];
        for (int i = 0; i < len; i++) {
           res[i][0] = ls.remove(0);
           res[i][1] = ls.remove(0);
        }
        return res;
    }

    // other
    public static int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals,(o1, o2) -> o1[0]-o2[0]);   // lamba表达式
        int idx = -1;
        int[][] res = new int[intervals.length][2];
        for (int[] interval : intervals) {
            if(idx == -1 || interval[0] > res[idx][1]){
                res[++idx] = interval;

            }else {
                res[idx][1] = Math.max(res[idx][1],interval[1]);
            }
        }
        return Arrays.copyOf(res,idx+1);
    }
}
