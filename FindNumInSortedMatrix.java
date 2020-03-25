package primary.coursethree.selfcode;
// 在行列都排好序的矩阵中找数
//【题目】 给定一个有N*M的整型矩阵matrix和一个整数K，matrix的每一行和每一列都是排好序的。
//        实现一个函数，判断K是否在matrix中。
//        例如： 0   1   2   5  2   3   4   7  4   4   4   8  5   7   7   9
//        如果K为7，返回true；如果K为6，返 回false
//【要求】 时间复杂度为O(N+M)，额外空间复杂度为O(1)。
public class FindNumInSortedMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,1,2,5},{2,3,4,7},{4,4,4,8},{5,7,7,9}};
        printMatrix(matrix);
        System.out.println("结果是："+isContain(matrix,9));
        System.out.println("结果是："+isContain(matrix,0));
        System.out.println("结果是："+isContain(matrix,11));
    }

    public static boolean isContain(int[][] m, int value){
        int cur_r = 0;
        int cur_c = m[0].length - 1;
        while(cur_r < m.length && cur_c > -1){
            if( value == m[cur_r][cur_c]){
                return true;
            }else if(value < m[cur_r][cur_c]){
                cur_c--;
            }else{
                cur_r++;
            }
        }
        return false;
    }


    public static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix[0].length; i1++) {
                System.out.print(matrix[i][i1]+" ");
            }
            System.out.println();
        }
    }

}
