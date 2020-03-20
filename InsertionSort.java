package primary.courseone.selfcode;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,3,7,12,2,44,12,1};
        System.out.print("排序前：");
        for(int ele:arr){
            System.out.print(ele+" ");
        }
        insertSort(arr);
        System.out.print("排序后：");
        for(int ele:arr){
            System.out.print(ele+" ");
        }
    }

    private static void insertSort(int[] arr) {
        if(arr == null || arr.length <2){
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for(int j=i-1; j>=0 && arr[j]>arr[j+1];j--){
                swap(arr,j,j+1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j] ;
        arr[j] = temp;
    }
}
