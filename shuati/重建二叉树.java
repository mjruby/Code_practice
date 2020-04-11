package offer;

//        输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
//        假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//                例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
//                则重建二叉树并返回。

// 递归
// Arrays.copyOfRange(in, 0, 3);  // 拷贝的是左闭右开

import java.util.ArrayList;
import java.util.Arrays;

public class 重建二叉树 {
    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode tr = reConstructBinaryTree(pre,in);
        System.out.println(tr.left.left.right.val);
        System.out.println(tr.right.right.left.val);
//        int[] ints = Arrays.copyOfRange(in, 0, 0);  // 拷贝的是左闭右开
//        System.out.println(Arrays.toString(ints)); // [4, 7, 2]
//        System.out.println(ints.length == 0);  // true
//        System.out.println(ints == null); // false
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0 || in.length == 0){
            return null;
        }
        TreeNode rootNode = new TreeNode(pre[0]);
        int len = in.length;
        for (int i = 0; i < len; i++) {
            if(pre[0] == in[i]){
                rootNode.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),
                        Arrays.copyOfRange(in,0,i));
                rootNode.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),
                        Arrays.copyOfRange(in,i+1,len));
                break;
            }
        }
        return rootNode;
    }
}



class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
