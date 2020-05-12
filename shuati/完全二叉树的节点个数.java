package leetcode;
// 给出一个完全二叉树，求出该树的节点个数。
public class 完全二叉树的节点个数 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);


        System.out.println(countNodes(head));
        System.out.println(countNodes1(head));
        System.out.println(countNodes2(head));
    }

    // 普通二叉树
    public static int countNodes(TreeNode root) {
        if(root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // 满二叉树
    public static int countNodes1(TreeNode root) {
        if(root == null) return 0;
        int h = 0;
        while(root != null){
            h++;
            root = root.left;
        }
        return (int)(Math.pow(2,h))-1;
    }

    // 完全二叉树 -- 必定的可拆分成一个子完全二叉树一个子满二叉树
    public static int countNodes2(TreeNode root) {
        if(root == null) return 0;
        int hl = 0, hr = 0;
        TreeNode curl = root.left;
        TreeNode curr = root.right;
        while(curl != null){
            hl++;
            curl = curl.left;
        }
        while(curr != null){
            hr++;
            curr = curr.right;
        }

        if(hl == hr) return (int)(Math.pow(2,hl+1))-1;

        return 1 + countNodes2(root.left) + countNodes2(root.right);
        // 只会进入左/右中的一个，因为左/右必有一个是满二叉树，结果立即返回
    }
}


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
