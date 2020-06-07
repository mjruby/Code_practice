package offer;
// 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。

import java.security.Principal;
import java.util.ArrayList;  
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 把二叉树打印成多行 {
    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(1);
        root.left = new TreeNode1(2);
        root.right = new TreeNode1(3);
        root.left.left = new TreeNode1(4);
        root.left.right = new TreeNode1(5);
        System.out.println(Print(root));
    }

    public static ArrayList<ArrayList<Integer>> Print(TreeNode1 pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if(pRoot == null) return lists;
        Queue<TreeNode1> q = new LinkedList<TreeNode1>();
        q.add(pRoot);
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode1 tmp = q.poll();
                list.add(tmp.val);
                if(tmp.left != null) q.add(tmp.left);
                if(tmp.right != null) q.add(tmp.right);
            }
            lists.add(list);
        }
        return lists;
    }
}

class TreeNode1 {
    int val = 0;
    TreeNode1 left = null;
    TreeNode1 right = null;

    public TreeNode1(int val) {
        this.val = val;

    }

}