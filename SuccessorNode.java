package primary.soursefour.selfcode;

import com.sun.security.jgss.GSSUtil;

// 在二叉树中找到一个节点的后继节点
//【题目】 现在有一种新的二叉树节点类型如下：
// public class Node {
//    public int value;
//    public Node left;
//    public Node right;
//    public Node parent;
//
//    public Node(int data) {
//        this.value = data; }
//}
public class SuccessorNode {
    public static class Node {
        public Integer data;
        public Node left;
        public Node right;
        public Node parent;

        public Node(Integer value) {
            this.data = value;
        }
    }

    public static void inTraversal(Node head){
        if(head == null) return;
        inTraversal(head.left);
        System.out.print(head.data + " ");
        inTraversal(head.right);
    }

    // 情况一：有右节点，后继是右半个子树的最左边界
    // 情况二：没有右结点，后继是第一次出现p.left = node的p
    public static Node successorNode(Node head){
        if(head == null) return null;
        if(head.right != null){
            // 找右子树的最左边界
            Node tmp = head.right;
            Node left = null;
            while(tmp!=null){
                left = tmp;
                tmp = tmp.left;
            }
            return left;
        }else{
            Node node = head;
            Node p = node.parent;
            while(p != null){  // p = null 出现在求最后一个结点的后继
                if(p.left == node) {
                    return p;
                }
                else{
                    node = p;
                    p = node.parent;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.parent = null;
        n1.left = new Node(2);
        n1.left.parent = n1;
        n1.right = new Node(3);
        n1.right.parent = n1;
        n1.left.left = new Node(4);
        n1.left.left.parent = n1.left;
        n1.left.right = new Node(5);
        n1.left.right.parent = n1.left;
        n1.right.left = new Node(6);
        n1.right.left.parent = n1.right;
        n1.right.right = new Node(7);
        n1.right.right.parent = n1.right;

        System.out.println("递归方法_中序遍历:");
        inTraversal(n1);

        System.out.println();
        System.out.println(n1.data+" 的后继是 "+successorNode(n1).data);
        System.out.println(n1.left.data+" 的后继是 "+successorNode(n1.left).data);
        System.out.println(n1.right.data+" 的后继是 "+successorNode(n1.right).data);
        System.out.println(n1.left.left.data+" 的后继是 "+successorNode(n1.left.left).data);
        System.out.println(n1.left.right.data+" 的后继是 "+successorNode(n1.left.right).data);
        System.out.println(n1.right.left.data+" 的后继是 "+successorNode(n1.right.left).data);
        System.out.println(n1.right.right.data+" 的后继是 "+successorNode(n1.right.right)); //java.lang.NullPointerException
    }
}
