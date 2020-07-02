package offer;

import java.util.ArrayList;

// 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
// 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
public class 二叉树中和为某一值的路径 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(FindPath(root,11));
    }

    // 不会还有负数吧？？
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
        if(root == null) return ls;
        ArrayList<Integer> track = new ArrayList<>();
        helper(root,track,target,ls);
        // 删除多余的
        ArrayList<ArrayList<Integer>> rs = new ArrayList<>();
        for (int i = 0; i < ls.size(); i=i+2) {
            rs.add(ls.remove(i));
        }
        return rs;
    }

    // 保留成功的路径，不符合要求的直接return,结束探索，因为track是new的所以直接抛弃不符合要求的就行
    private static void helper(TreeNode root, ArrayList<Integer> track, int target, ArrayList<ArrayList<Integer>> ls) {
        if(root != null && root.val > target || root == null && target != 0){
            return;
        }
        if(root == null && target == 0){
            ls.add(new ArrayList<>(track));
            return;
        }
        track.add(root.val);
        target = target - root.val;
        helper(root.left,new ArrayList<>(track),target,ls);  // 使用new就不用考虑这次的路径对另一边有什么影响了
        helper(root.right,new ArrayList<>(track),target,ls);
    }
}
