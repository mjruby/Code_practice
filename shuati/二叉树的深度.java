package offer;
// 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
// 最长路径的长度为树的深度。
public class 二叉树的深度 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.left.left = new TreeNode(7);
        System.out.println(TreeDepth(root));
    }

    public static int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        int leftDep = TreeDepth(root.left);
        int rightDep = TreeDepth(root.right);
        return Math.max(leftDep,rightDep)+1;
    }
}
