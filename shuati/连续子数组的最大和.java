package offer;

public class 连续子数组的最大和 {
    public static void main(String[] args) {
        int[] array = {6,-3,-2,7,-15,1,2,2};
        System.out.println(FindGreatestSumOfSubArray(array));

        int[] array1 = {-2};
        System.out.println(FindGreatestSumOfSubArray(array1));
    }

    public static int FindGreatestSumOfSubArray(int[] array) {
        int len = array.length;
        int max_val = Integer.MIN_VALUE;
        int tmp_val = 0;
        for (int i = 0; i < len; i++) {
            tmp_val += array[i];
            max_val = Math.max(max_val,tmp_val);  //【注意】数组中可能全为负值
            if(tmp_val <= 0) tmp_val = 0;
        }
        return max_val;
    }
}
