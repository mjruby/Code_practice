package primary.courseone.selfcode;
//一个数组，小于等于num的数放左边，其他放右边
public class SmallEqualLeft {
    public static void main(String[] args) {
        int[] arr = new int[]{2,6,7,3,9,4,6,1,12,3,5};
        int num = 5;
        smallEqualLeft(arr,num);
        for (int i : arr) {
            System.out.print( i+" ");
        }
    }

    private static void smallEqualLeft(int[] arr, int num) {
        int less = -1;
        int cur = 0;
        while( cur < arr.length){
            if(arr[cur] > num){
                cur++;
            }else{
                swap(arr,cur++,++less);
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
