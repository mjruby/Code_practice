package primary.courseone.selfcode;
// 随机快速排序,与荷兰国旗问题有关
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,6,7,3,9,4,6,1,12,3,5,100,3,3,2};
        quickSort(arr);

        for (int i : arr) {
            System.out.print( i+" ");
        }
    }

    public static void quickSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        quickSort(arr,0,arr.length-1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
//            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    //随机选择一个数划分，让左边都比这个数小，右边都比它大，等于它的放中间，返回中间段的左右下标
    public static int[] partition(int[] arr, int l,int r){
        //随机选择一个数与最后一个数交换
        int rn = l+(int)Math.random()*(r-l+1);
        swap(arr,rn,r);
        int less = l-1;   //错误的把 l-1,写成固定的-1
        int more = r;
        while(l < more){
            if(arr[l] < arr[r]){
                swap(arr,++less,l++);
            }else if(arr[l] > arr[r]){
                swap(arr,l,--more);
            }else{
                l++;
            }
        }
        swap(arr,more,r);
        return new int[]{less+1,more};
    }


    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

