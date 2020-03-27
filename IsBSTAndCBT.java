package primary.soursefour.selfcode;
// 判断一棵树是否是搜索二叉树、判断一棵树是否是完全二叉树

// 【思路】二叉树中序遍历的结果是升序的，则是搜索二叉树（通常搜索二叉树是没有重复结点的）

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 【思路】按层遍历，如果遇到有右孩子没有左孩子，直接返回false; 如果遇到左右孩子不全，则开启新的阶段
// 后面的结点都要是叶子结点，否则不是完全二叉树。
public class IsBSTAndCBT {

    public static class Node{
        Integer data;
        Node left;
        Node right;
        public Node(Integer value){
            this.data = value;
        }
    }

    public static Boolean isBST(Node head){
        if(head == null) return true;
        Stack<Node> stack = new Stack<>();
        Node node = head;
        Integer tmp = Integer.MIN_VALUE;
        while( node != null || !stack.isEmpty()){  // 判断条件 ***
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if(tmp > node.data){
                return false;
            }else{
                tmp = node.data;
            }
            node = node.right;
        }
        return  true;
    }

    public static Boolean isCBT(Node head){
        if(head == null) return true;
        // 按层遍历
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(head);
        Boolean leaf = false;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if((node.left == null && node.right != null) ||
                    (leaf && (node.left !=null||node.right !=null)))
                return  false;
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
            if(node.left == null || node.right == null){
                leaf = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node n1 = new  Node(1);
        n1.left = new Node(2);
        n1.right = new Node(3);
        n1.left.left = new Node(4);
        n1.left.right = new  Node(5);
        n1.right.left = new  Node(6);
        n1.right.right = new Node(7);

        Node n2 = new  Node(8);
        n2.left = new Node(5);
        n2.right = new Node(10);
        n2.left.left = new Node(4);
        n2.left.right = new  Node(6);
        n2.right.left = new  Node(9);
        n2.right.right = new Node(11);

        Node n3 = new  Node(8);
        n3.left = new Node(5);
        n3.right = new Node(10);
        n3.left.left = new Node(4);
        n3.right.left = new  Node(9);
        n3.right.right = new Node(11);

        Node n4 = new  Node(8);
        n4.left = new Node(5);
        n4.right = new Node(10);
        n4.left.left = new Node(4);
        n4.left.right = new  Node(6);



        System.out.println("是否是搜索二叉树："+ isBST(n1));  // false
        System.out.println("是否是搜索二叉树："+ isBST(n2));  // true
        System.out.println();
        System.out.println("是否是完全二叉树："+ isCBT(n1));  // true
        System.out.println("是否是完全二叉树："+ isCBT(n3));  // false
        System.out.println("是否是完全二叉树："+ isCBT(n4));  // true
    }
}
