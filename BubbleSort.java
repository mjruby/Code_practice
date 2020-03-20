package primary.courseone.selfcode;

import static basic_class_01.Code_00_BubbleSort.bubbleSort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,3,7,12,2};
        bubbleSort(arr);
        for(int ele:arr){
            System.out.print(ele+" ");
        }

    }

    public static void bubbleSort(int[] arr){
        if((arr == null)|| arr.length < 2){
            return;
        }
        for (int i = arr.length -1 ;i > 0; i--) {
            for (int j = 0; j< i; j++) {
                if(arr[j] > arr[j+1])
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

