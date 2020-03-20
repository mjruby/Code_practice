package primary.courseone.selfcode;
//一个数组，小于等于num的数放左边，等于num的放中间，其他放右边
public class HelanFlag {
    public static void main(String[] args) {
        int[] arr = new int[]{2,6,7,3,9,4,5,6,1,12,3,5,1,5};
        int num = 5;
        helanFlag(arr,num);
        for (int i : arr) {
            System.out.print( i+" ");
        }
    }

    private static void helanFlag(int[] arr, int num) {
        int less = -1;
        int more = arr.length;
        int cur = 0;
        while( cur < more){
            if(arr[cur] < num){
                swap(arr,cur++,++less);
            }else if( arr[cur] > num){
                swap(arr,cur,--more);
            }else{
                cur++;
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
