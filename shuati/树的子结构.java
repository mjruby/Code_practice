package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 输入两棵二叉树A，B，判断B是不是A的子结构。
// （ps：我们约定空树不是任意一个树的子结构）
public class 树的子结构 {
    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(8);
        root1.right = new TreeNode(8);
        root1.right.right = new TreeNode(9);
        root1.right.right.right = new TreeNode(2);
        root1.right.right.right.right = new TreeNode(5);


        TreeNode root2 = new TreeNode(8);
        root2.right = new TreeNode(9);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(2);
        System.out.println(HasSubtree1(root1,root2));
    }

    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2 == null  || root1 == null) return false;
        int target = root2.val;
        ArrayList<TreeNode> rss = findTarget(root1, target);
        if(rss.size() == 0) return false;
        boolean rs = false;
        while(!rss.isEmpty()){
            TreeNode t1 = rss.remove(0);
            TreeNode t2 = root2;
            if(isSub(t1,t2)){
                rs = true;
                break;
            }
        }
        return rs;
    }

    // 寻找tree1和tree2起始相同的结点，按层遍历
    public static ArrayList<TreeNode> findTarget(TreeNode root, int target){ // 多个目标
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        ArrayList<TreeNode> rss = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode tmp = q.remove();
            if(tmp.val == target) rss.add(tmp);
            if(tmp.left != null) q.add(tmp.left);
            if(tmp.right != null) q.add(tmp.right);
        }
        return rss;
    }
    // 递归
    public static boolean isSub(TreeNode t1,TreeNode t2){
        if(t1 == null || t1.val != t2.val) return false;
        if(t2 == null) return true;
        boolean b1 = true; boolean b2 = true;
        if(t2.left != null) {
             b1 = isSub(t1.left, t2.left);
        }
        if(t2.right != null) {
             b2 = isSub(t1.right, t2.right);
        }
        return b1 && b2;
    }

    // other 递归
    public static boolean HasSubtree1(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root1 != null && root2 != null){
            if(root1.val == root2.val){
                result = doesTree1hasTree2(root1,root2);
            }
            if(!result){
                result = HasSubtree1(root1.left,root2);
            }
            if(!result){
                result = HasSubtree1(root1.right,root2);
            }
        }
        return result;
    }
    public static boolean doesTree1hasTree2(TreeNode node1,TreeNode node2){
        if(node2 == null) return true;
        if(node1 == null) return false;
        if(node1.val != node2.val) return false;
        // 子结点
        return doesTree1hasTree2(node1.left,node2.left) && doesTree1hasTree2(node1.right,node2.right);
    }
}

