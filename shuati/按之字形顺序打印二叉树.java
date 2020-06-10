package offer;

import java.nio.charset.IllegalCharsetNameException;
import java.util.*;

// 请实现一个函数按照之字形打印二叉树，
// 即第一行按照从左到右的顺序打印，
// 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，
// 其他行以此类推。
public class 按之字形顺序打印二叉树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        ArrayList<ArrayList<Integer>> rs = Print(root);
        System.out.println(rs);
    }

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if(pRoot != null){
            Deque<TreeNode> q = new LinkedList<>();
            q.add(pRoot);
            boolean leftToright = true;
            while (!q.isEmpty()){
                int size = q.size();
                ArrayList<Integer> ls = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    if(leftToright){
                        TreeNode tmp = q.pollFirst();
                        ls.add(tmp.val);
                        if(tmp.left != null) q.addLast(tmp.left);
                        if(tmp.right != null) q.addLast(tmp.right);
                    }else {
                        TreeNode tmp = q.pollLast();
                        ls.add(tmp.val);
                        if(tmp.right != null) q.addFirst(tmp.right);
                        if(tmp.left != null) q.addFirst(tmp.left);
                    }
                }
                leftToright = !leftToright;
                lists.add(ls);
            }
        }
        return lists;
    }
}
