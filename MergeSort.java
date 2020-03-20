package primary.courseone.selfcode;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,3,7,12,2,44,12,1};
        System.out.print("排序前：");
        for(int ele:arr){
            System.out.print(ele+" ");
        }
       /* System.out.println("==========================");
        int arr1[] = new int[]{1,4,5,2,5,7};
        merge(arr1,0,2,arr1.length-1);
        for(int ele:arr1){
            System.out.print(ele+" ");
        }
*/
        mergeSort(arr);
        System.out.print("排序后：");
        for(int ele:arr){
            System.out.print(ele+" ");
        }

    }
    public static void mergeSort(int[] arr){
        if(arr == null || arr.length <2)
            return;
        mergeSort(arr,0, arr.length-1);
    }


    public static void mergeSort(int[] arr, int l,int r){
        if(l==r){
            return;
        }
        int mid = l + ((r-l)>>1);
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r); //将merge好的左边和右边merge下

    }

    public static void merge(int[] arr, int l,int m, int r){
        int[] tmp = new int[r-l+1];
        int i = l;
        int j = m +1 ;
        int k = 0;
        while(i<=m && j<=r){
            /*tmp[k++] = arr[i] < arr[j]? arr[i++]:arr[j++];*/
            if(arr[i] < arr[j]){
                tmp[k++] = arr[i++];
            }else{
                tmp[k++] = arr[j++];
            }
        }
        while(i <= m){
            tmp[k++] = arr[i++];
        }
        while(j <= r){
            tmp[k++] = arr[j++];
        }
        for(int e=0; e<tmp.length;e++){
            arr[l+e] = tmp[e];
        }
    }
}
