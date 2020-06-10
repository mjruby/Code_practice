package offer;

// 请实现一个函数，用来判断一颗二叉树是不是对称的。
// 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
public class 对称的二叉树 {
    public static void main(String[] args) {
        // 下面的树是镜像，主要在于镜像的理解，

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(5);
        root.right.right.right = new TreeNode(5);
        System.out.println(isSymmetrical(root));
    }

    static boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        boolean rs = helper(pRoot.left, pRoot.right);
        return rs;
    }

    public static boolean helper(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null || t1.val != t2.val ) return false;
        return helper(t1.left,t2.right) && helper(t1.right,t2.left);// 左孩子的左子树和右孩子的右子树是否镜像，及左孩子的右子树和右孩子的左子树是否镜像。
    }
}

