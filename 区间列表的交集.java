package leetcode;
// 给定两个由一些闭区间组成的列表，每个区间列表都是成对不相交的，并且已经排序。
//返回这两个区间列表的交集。
//（形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b。
// 两个闭区间的交集是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3]。）
//
// 输入：A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
//输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
// 注意：输入和所需的输出都是区间对象组成的列表，而不是数组或列表。


import java.util.Arrays;

// 存在交集：b2 >= a1 && a2 >= b1
public class 区间列表的交集 {
    public static void main(String[] args) {
//        int[][] A ={{0,2},{5,10},{13,23},{24,25}}, B = {{1,5},{8,12},{15,24},{25,26}};
        int[][] A ={{1,3},{5,9}}, B = {};
        int[][] res = intervalIntersection(A, B);
        test.printInts(res);
    }

    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        int len1 = A.length;
        int len2 = B.length;
        int[][] res = new int[len1+len2][2];
        if(A.length == 0 || B.length == 0) return new int[][]{};

        int i = 0; int j=0; int k = 0;
        while (i < len1 && j < len2){
            int a1 = A[i][0], a2 = A[i][1];
            int b1 = B[j][0], b2 = B[j][1];
            if(b2 >= a1 && a2 >= b1){
                res[k][0] = Math.max(a1,b1);
                res[k][1] = Math.min(a2,b2);
                k++;
            }

            if(b2 < a2) j++;
            else i++;
        }
        return Arrays.copyOf(res,k);
    }
}
