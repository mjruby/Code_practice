package offer;
// 统计一个数字在排序数组中出现的次数。
public class 数字在排序数组中出现的次数 {
    public static void main(String[] args) {
        int[] arr={1,2,3,3,3,3};
        int k= 3;
        System.out.println(GetNumberOfK(arr,k));
    }

    public static int GetNumberOfK(int [] array , int k) {
        int count = 0;
        for (int i = 0; i < array.length; ) {
            if(array[i] < k){
                i++;
            }else if(array[i]==k){
                i++;
                count++;
            }else if(array[i] >k){
                break;
            }
        }
        return count;
    }
}
