package offer;
//在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
//        每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
//        判断数组中是否含有该整数。
public class 二维数组查找 {
    public static void main(String[] args) {
        int target= 16;
        int[][] arr = {{1,3,4,5},{2,4,7,8},{4,6,11,12}};
        Solution s = new Solution();
        System.out.println(s.Find(target,arr));
    }

}

class Solution {
    public boolean Find(int target, int [][] array) {
        if(array == null) return false;
        int nrow = array.length;
        int ncol = array[0].length;

        int i = 0;
        int j = ncol-1;
        while(i<nrow && j>=0){
            if(target == array[i][j]){
                return true;
            }else if(target > array[i][j]){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
}
