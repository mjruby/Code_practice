package offer;

import leetcode.test;

import java.util.ArrayList;

// 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
// 如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
// 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
//

// 【注意】不是方阵
public class 顺时针打印矩阵 {
    public static void main(String[] args) {
 /*       int[][] nums = {{1, 2, 3, 4,5},{ 6, 7, 8,9,10},{11, 12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}}; // 试试不是方针
        ArrayList<Integer> rs = printMatrix(nums);
        System.out.println(rs); //[1, 2, 3, 4, 5, 10, 15, 20, 25, 24, 23, 22, 21, 16, 11, 6, 7, 8, 9, 14, 19, 18, 17, 12, 13]

        int[][] nn = {{1,2},{3,4}};
        System.out.println(printMatrix(nn)); // [1, 2, 4, 3]*/

        int[][] n = {{1,2,3,4}};
        System.out.println(printMatrix(n)); // [1, 2, 3, 4]

        int[][] n1 = {{1},{2},{3},{4}};
        System.out.println(printMatrix(n1)); // [1, 2, 3, 4]
/*
        int[][] nums1 = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        System.out.println(printMatrix(nums1)); // [1, 2, 3, 6, 9, 12, 11, 10, 7, 4, 5, 8]

        int[][] nums2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(printMatrix(nums2)); // [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]

        int[][] nums3 = {{1,2},{3,4},{5,6},{7,8},{9,10}};
        System.out.println(printMatrix(nums3)); // [1, 2, 4, 6, 8, 10, 9, 7, 5, 3]*/
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> rs = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return rs;
        int start_i = 0, start_j = 0;  // 左上点
        int end_i = matrix.length-1, end_j = matrix[0].length-1; // 右下点

        // 【特例：单位向量】
        int len1 = matrix.length, len2 = matrix[0].length;
        if (len1 == 1 || len2 == 1) {
            if (len1 == 1) {
                for (int i = 0; i < len2; i++) {
                    rs.add(matrix[0][i]);
                }
            } else {
                for (int i = 0; i < len1; i++) {
                    rs.add(matrix[i][0]);
                }
            }
            return rs;
        }

        while (start_i < end_i && start_j < end_j) {  // 【奇方针 / 偶方针】
            // 上
            for (int i = start_j; i < end_j; i++) {
                rs.add(matrix[start_i][i]);
            }
            // 右
            for (int i = start_i; i < end_i; i++) {
                rs.add(matrix[i][end_j]);
            }
            // 下
            for (int i = end_j; i > start_j; i--) {
                rs.add(matrix[end_i][i]);
            }
            // 左
            for (int i = end_i; i > start_i; i--) {
                rs.add(matrix[i][start_j]);
            }
            // 变更左上和右下点
            start_i++;
            start_j++;
            end_i--;
            end_j--;
        }
        //【不是方阵，要处理下面情况】
        if(start_i == end_i && start_j <= end_j){
            for (int i = start_j; i <= end_j; i++) {
                rs.add(matrix[start_i][i]);
            }
        }
        return rs;
    }
}
