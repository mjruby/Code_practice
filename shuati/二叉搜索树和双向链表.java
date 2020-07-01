package offer;

import java.sql.Connection;
import java.util.ArrayList;

// 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
public class 二叉搜索树和双向链表 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(6);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(10);
        TreeNode rs = Convert1(root);
        printDoubleList(rs);

    }

    public static TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return pRootOfTree;
        // 中序遍历，将有序结果保存在ls中
        ArrayList<TreeNode> ls = new ArrayList<>();
        midSearch(pRootOfTree,ls);
        // 根据ls中排好序的结点，把它们组成双向链表
        for (int i = 0; i < ls.size()-1; i++) {
            ls.get(i).right = ls.get(i+1);
            ls.get(i+1).left = ls.get(i);
        }
        return ls.get(0);
    }

    public static void midSearch(TreeNode node,ArrayList<TreeNode> ls){
        if(node == null) return;
        midSearch(node.left,ls);
        ls.add(node);
        midSearch(node.right,ls);
    }

    // 打印双向链表瞅瞅
    public static void printDoubleList(TreeNode r){
        while(r!=null){
            System.out.print(r.val+"-->");
            r = r.right;
        }
    }


    // other: https://blog.nowcoder.net/n/ef0eb5531319434e98fedcb41a6bff63?f=comment
    // 递归的过程中改变指针
    // 不能把变量作为递归函数的形参，因为每次递归返回时此变量都会变为上层递归时此变量的值。
    // 所以这里的变量不作为inOrderConvert()的形式参数，而又由于在两个方法中都用到了此变量，所以将其定义在了所有方法的外面。

    static TreeNode lastNode = null;
    public static TreeNode Convert1(TreeNode root) {
        if(root == null) return root;
        inOrderConvert(root);
        // 寻找头结点
        while(lastNode.left!=null){
            lastNode = lastNode.left;
        }
        return lastNode;
    }

    public static void inOrderConvert(TreeNode root){
        if(root == null)
            return;
        inOrderConvert(root.left);
        if(lastNode != null)
            lastNode.right = root;
        root.left = lastNode;
        lastNode = root;
        inOrderConvert(root.right);
    }
}
