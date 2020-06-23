package offer;

import java.util.ArrayList;

// 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
// 如果有多对数字的和等于S，输出两个数的乘积最小的。
public class 和为S的两个数 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int sum = 5;
        System.out.println(FindNumbersWithSum(arr,sum));
    }

    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> rs = new ArrayList<>();
        if(array.length<2 || array == null) return rs;
        int cj = Integer.MAX_VALUE;
        for (int i = 0,j=array.length-1; i < j;) {
            if((array[i]+ array[j])>sum){
                j--;
            }else if((array[i]+array[j])<sum){
                i++;
            }else {
                if((array[i]*array[j])<cj){
                    rs.clear();
                    rs.add(array[i]);
                    rs.add(array[j]);
                    cj = array[i]*array[j];
                }
                i++;
            }
        }
        return rs;
    }
}
