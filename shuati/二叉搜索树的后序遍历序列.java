package offer;

import leetcode.实现strStr;

// 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
// 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
public class 二叉搜索树的后序遍历序列 {

    public static void main(String[] args) {
        int[] arr = {1,3,2,5,7,6,4};
        System.out.println(VerifySquenceOfBST(arr));

        int[] arr1 = {6,4,3,7,5};
        System.out.println(VerifySquenceOfBST(arr1));

        int[] arr2 = {1,2,3,4,5};
        System.out.println(VerifySquenceOfBST(arr2));

        int[] arr3 = {};  // 【要求是输出false】
        System.out.println(VerifySquenceOfBST(arr3));

    }


    // other people【后序遍历，数组的最后一个值为根节点上的值，左子树上所有点小于根，右子树的所有点大于根 === 递归】
    public static boolean VerifySquenceOfBST(int [] sequence) {
//        if(sequence.length == 0) return false;  //【特例，为空判定为false】
//        if(sequence == null || sequence.length == 1) return true; //【可以只判断长度为1】
        if(sequence == null || sequence.length == 0) return false;
        int start = 0, end = sequence.length-1;
        return helper(sequence,start,end);
    }

    public static boolean helper(int[] seq,int start,int end){
        if(start >= end) return true;
        int root = seq[end];
        // 判断以root为根是否大于左边的，小于右边的
        int split = start,i = start;
        for (i = start; i < end; i++) {
            if(seq[i] > root) {
                break;
            }
        }
        split = i;  // 【在外面很重要，因为数组可能是 1 2 3 4 5】
            // split是右子树开始的第一个位置，判断是否都大于root
        for (i = split; i < end; i++) {
            if(seq[i] < root) return false;
        }
        return helper(seq,start,split-1) && helper(seq,split,end-1);
    }
}
