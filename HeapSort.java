package primary.courseone.selfcode;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,6,7,3,9,4,6,1,12,3,5,100,3,3,2,1,200};
        heapSort(arr);
        for (int i : arr) {
            System.out.print( i+" ");
        }
    }

    public static void heapSort(int[] arr){
        if((arr == null) || arr.length <2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
        }

        int size = arr.length;
        swap(arr,0,--size);
        while(size > 0){
            heapIfy(arr,0,size);
            swap(arr,0,--size);
        }
    }

    private static void heapInsert(int[] arr, int i) {
        while(arr[i] > arr[(i-1)/2]){ // (i-1)/2 对应着i的父节点
            swap(arr,i,(i-1)/2);
            i = (i-1)/2;
        }
    }

    public static void heapIfy(int[] arr,int i,int size){  //调整新的arr[0],按情况下沉
        int left = (2*i) + 1;  //left 左节点； left+1 右节点
        while(left < size){
            int largest = (left+1 < size)&&(arr[left+1]>arr[left]) ? (left+1):left;
            largest = arr[i] > arr[largest] ? i : largest;
            if(largest == i){
                break;
            }else{
                swap(arr,i,largest);
                i = largest;
                left = (2*i) + 1;
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
