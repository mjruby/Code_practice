package primary.courseone.selfcode;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,3,7,12,2,44,12,1};
        System.out.print("排序前：");
        for(int ele:arr){
            System.out.print(ele+" ");
        }
        selectionSort(arr);
        System.out.print("排序后：");
        for(int ele:arr){
            System.out.print(ele+" ");
        }
    }

    private static void selectionSort(int[] arr) {
        if((arr == null) || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for(int j = i+1; j < arr.length; j++){
               minIndex = arr[j] < arr[minIndex]? j : minIndex ;
            }
            swap(arr,i,minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j] ;
        arr[j] = temp;
    }
}
