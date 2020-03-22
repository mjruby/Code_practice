package primary.courseone.selfcode;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,3,2,7,6,4,1,3};
        printArray(arr);

        bucketSort(arr);
        printArray(arr);
    }

    public static void bucketSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        // 找出最大值，创建桶
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int[] bucket = new int[max+1];
        // 将数放入桶中，计数
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        // 按桶，输出最后结果
        int k = 0;
        for (int i = 0; i < bucket.length; i++) {
            while(bucket[i]-- > 0){
                arr[k++] = i;
            }
        }
    }
    public static void printArray(int[] arr){
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
