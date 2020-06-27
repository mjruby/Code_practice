package offer;
// 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
// 输入一个数组,求出这个数组中的逆序对的总数P。
// 并将P对1000000007取模的结果输出。 即输出P%1000000007

import java.awt.print.PrinterGraphics;
import java.util.Arrays;
import java.util.Random;

public class 数组中的逆序对 {


    public static int InversePairs1(int [] array) {
        if(array.length <= 1 ) return 0;
        return helper(array,0,array.length);
    }

    private static int helper(int[] arr, int start, int end) {  // 左闭右开
        if(start == end-1) return 0;  //【关键：左闭右开，结束条件是start == end-1】
        int mid = start+((end-start)>>1);
        int l = helper(arr,start,mid);
        int r = helper(arr,mid,end);
        return (l+r+merge(arr,start,mid,end))%1000000007;  //【没取余只通过50% 】
        //【类比一下： 2%6+5%6=7，而(2+5)%6=1,二者并不相等，归并思路是分而治之，就像楼主说的[AB]逆序对数目等于=AA+BB+CC
        // ，总数都话你可以每次累加后放回，总函数再返回，但题目要求是逆序对%1000000007，
        // 所以[AB]=AA%100000007+BB%1000000007+CC%1000000007,这也是分而治之的思想表现】

        // 解决方法： (a + b) % p = (a % p + b % p) % p ，每一步计算cnt都取模，最后返回的时候也取模就ok了
    }

    private static int merge(int[] arr, int l, int m, int r) {
        int len = r - l;
        int[] tmp = new int[len];
        int k = 0 ,p = l,q=m;  // 【新的指标,m的值要作为左边结束的标志，不要作为指针乱动，用新的指针】
        int count = 0;
        while(p<m && q < r){
            if(arr[p] <= arr[q]){
                tmp[k++] = arr[p++];
            }
            else {
                //如果前面的元素大于后面的，那么在前面元素之后的元素都能和后面的元素构成逆序对
                count = (count+(m-p))%1000000007;
                tmp[k++] = arr[q++];
            }
        }
        while(p<m){
            tmp[k++] = arr[p++];
        }
        while(q<r){
            tmp[k++] = arr[q++];
        }

        for(int i =0;i<k;i++){
            arr[l++] = tmp[i];
        }
        return count;
    }



    // other :也是归并排序（左闭右闭）

    private static int cnt;
    private static void MergeSort(int[] array, int start, int end){
        if(start>=end)return;
        int mid = (start+end)/2;
        MergeSort(array, start, mid);
        MergeSort(array, mid+1, end);
        MergeOne(array, start, mid, end);
    }
    private static void MergeOne(int[] array, int start, int mid, int end){
        int[] temp = new int[end-start+1];
        int k=0,i=start,j=mid+1;
        while(i<=mid && j<= end){
            //如果前面的元素小于后面的不能构成逆序对
            if(array[i] <= array[j])
                temp[k++] = array[i++];
            else{
                //如果前面的元素大于后面的，那么在前面元素之后的元素都能和后面的元素构成逆序对
                temp[k++] = array[j++];
                cnt = (cnt + (mid-i+1))%1000000007;
            }
        }
        while(i<= mid)
            temp[k++] = array[i++];
        while(j<=end)
            temp[k++] = array[j++];
        for(int l=0; l<k; l++){
            array[start+l] = temp[l];
        }
    }
    public static int InversePairs(int [] array) {
        MergeSort(array, 0, array.length-1);
        return cnt;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,0};
        int cnt = InversePairs(arr);
        System.out.println(cnt);
    }
}
