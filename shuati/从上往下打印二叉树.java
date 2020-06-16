package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
public class 从上往下打印二叉树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        ArrayList<Integer> rs = PrintFromTopToBottom(root);
        System.out.println(rs);
    }

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> ls = new ArrayList<>();
        if(root == null) return ls;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            ls.add(node.val);
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }
        return ls;
    }
}
