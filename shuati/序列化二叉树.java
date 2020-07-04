package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 序列化二叉树 {

    public static void main(String[] args) {
       TreeNode node = new TreeNode(1);
       node.left = new TreeNode(2);
       node.right = new TreeNode(3);
       node.right.left = new TreeNode(4);
       String str = Serialize(node);
       System.out.println(str); // 1!2!#!#!3!4!#!#!#!
       TreeNode rs = Deserialize(str);
       System.out.println(rs.left.val);
    }


//    // 序列化会，反序列化不会
//    static StringBuilder sb = new StringBuilder();
//    static String Serialize1(TreeNode root) {
//        if(root == null) return "";
//        helper(root);
//        return sb.toString();
//    }
//
//    private static void helper(TreeNode root) {
//        if(root == null){
//            sb.append("#!");
//            return;
//        }
//        sb.append(root.val+"!");
//        helper(root.left);
//        helper(root.right);
//    }

    // other
    static int idx = -1;
    public static String Serialize(TreeNode root){
        if(root == null){
            return "#";
        }else {
            return root.val+","+Serialize(root.left)+","+Serialize(root.right);
        }
    }

    // 反序列化
    static TreeNode Deserialize(String str) {
        String[] s = str.split(",");
        idx++;
        int len = s.length;
        if (idx > len) {
            return null;
        }
        TreeNode treeNode = null;
        if (!s[idx].equals("#")) {
            treeNode = new TreeNode(Integer.parseInt(s[idx]));
            treeNode.left = Deserialize(str);
            treeNode.right = Deserialize(str);
        }
        return treeNode;  // 这一层的结点
    }

}
