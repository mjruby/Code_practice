package primary.soursefour.selfcode;

import java.util.Stack;
// 实现二叉树的先序、中序、后序遍历，包括递归方式和非递归 方式
public class PreInPosTraversal {

    public static class Node{
        Integer data;
        Node right;
        Node left;

        public Node(Integer value){
            this.data = value;
        }
    }

    public static void preTraversal(Node head){
        if(head == null) return;
        System.out.print(head.data + " ");
        preTraversal(head.left);
        preTraversal(head.right);
    }

    public static void inTraversal(Node head){
        if(head == null) return;
        inTraversal(head.left);
        System.out.print(head.data + " ");
        inTraversal(head.right);
    }

    public static void posTraversal(Node head){
        if(head == null) return;
        posTraversal(head.left);
        posTraversal(head.right);
        System.out.print(head.data + " ");
    }

    public static void preOrderUnRecur(Node head){
        if(head == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()){
            head = stack.pop();
            System.out.print(head.data+" ");
            if(head.right != null){
                stack.push(head.right);
            }
            if(head.left != null){
                stack.push(head.left);
            }
        }
    }

    public static void inOrderUnRecur(Node head){
        if(head == null) return;
        Stack<Node> stack = new Stack<>();
        while(head != null || !stack.isEmpty()){
            while(head != null){
                stack.push(head);
                head = head.left;
            }
            head = stack.pop();
            System.out.print(head.data+" ");
            head = head.right;
        }
    }

    //  基于先序遍历思想，使其完成 中右左 放入栈中再取出，即为左右中
    public static void posOrderUnRecur(Node head){
        if(head == null) return;
        Stack<Node> stack = new Stack<>();
        Stack<Node> st = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()){
            head = stack.pop();
            st.push(head);
            if(head.left != null){
                stack.push(head.left);
            }
            if(head.right != null){
                stack.push(head.right);
            }
        }
        while(!st.isEmpty()){
            System.out.print(st.pop().data+" ");
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.left = new Node(2);
        n1.right = new Node(3);
        n1.left.left = new Node(4);
        n1.left.right = new Node(5);
        n1.right.left = new Node(6);
        n1.right.right = new Node(7);

        System.out.println("递归方法_先序遍历:");
        preTraversal(n1);
        System.out.println();
        System.out.println("递归方法_中序遍历:");
        inTraversal(n1);
        System.out.println();
        System.out.println("递归方法_后序遍历:");
        posTraversal(n1);

        System.out.println();
        System.out.println("==============================================");
        System.out.println();
        System.out.println("非递归方法_先序遍历:");
        preOrderUnRecur(n1);
        System.out.println();
        System.out.println("非递归方法_中序遍历:");
        inOrderUnRecur(n1);
        System.out.println();
        System.out.println("非递归方法_后序遍历:");
        posOrderUnRecur(n1);
    }

}
