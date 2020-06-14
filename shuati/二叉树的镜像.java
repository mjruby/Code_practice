package offer;

// 操作给定的二叉树，将其变换为源二叉树的镜像。
public class 二叉树的镜像 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        Mirror(root);
        System.out.println(root.left.right.right);
    }

    public static void Mirror(TreeNode root) {
        if(root == null) return;
        // 交换左右孩子
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        // 左结点为头的进行上述操作
        Mirror(root.left);
        // 右结点为头的进行上述操作
        Mirror(root.right);
    }
}
