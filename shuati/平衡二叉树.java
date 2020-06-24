package offer;
// 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
//
//在这里，我们只需要考虑其平衡性，不需要考虑其是不是
public class 平衡二叉树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
//        root.left.right.left = new TreeNode(6);
        System.out.println(IsBalanced_Solution(root));
    }

    public static boolean IsBalanced_Solution1(TreeNode root) {
        if(root == null) return true;
        ReturnClass rs = helper(root);
        return rs.isB;
    }

    private static ReturnClass helper(TreeNode root) {
        if(root == null) return new ReturnClass(0,true);
        ReturnClass left = helper(root.left);
        ReturnClass right = helper(root.right);
        if(left.isB == false || right.isB == false)
            return new ReturnClass(0,false);
        int numLeft = left.num;
        int numRight = right.num;
        if( Math.abs(numLeft - numRight) > 1)
            return new ReturnClass(0,false);
        return new ReturnClass(Math.max(numLeft,numRight)+1,true);
    }

    static class ReturnClass{
        int num;
        boolean isB;

        public ReturnClass(int num, boolean isB) {
            this.num = num;
            this.isB = isB;
        }
    }

    // other: 当判断出不是平衡二叉树，可直接返回-1；
    public static boolean IsBalanced_Solution(TreeNode root) {
        if(depth(root)!=-1) return true;
        else return false;
    }

    public static int depth(TreeNode root){
        if(root == null) return 0;
        int numLeft = depth(root.left);
        if(numLeft == -1) return -1;
        int numRight = depth(root.right);
        if(numRight == -1) return -1;
        if(Math.abs(numLeft - numRight)>1) return -1;
        return Math.max(numLeft,numRight)+1;
    }
}
