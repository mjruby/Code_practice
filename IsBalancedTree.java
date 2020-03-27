package primary.soursefour.selfcode;
// 判断一棵二叉树是否是平衡二叉树
public class IsBalancedTree {

    public static class Node{
        Integer data;
        Node left;
        Node right;

        public Node(Integer value){
            this.data = value;
        }
    }

    public static class ReturnData{
        Boolean isB;
        Integer h;
        public  ReturnData(Boolean isB, Integer h){
            this.isB = isB;
            this.h = h;
        }
    }

    public static Boolean isBTree(Node head){
        return isBalance(head).isB;
    }

    public static ReturnData isBalance(Node head){
        if(head == null){
            return new ReturnData(true,0);
        }
        ReturnData leftData = isBalance(head.left);  // 假设可以收到左边
        if(!leftData.isB){
            return new ReturnData(false,0);
        }
        ReturnData rightData = isBalance(head.right);
        if(!rightData.isB){
            return new ReturnData(false,0);
        }
        if(Math.abs(leftData.h-rightData.h) > 1){
            return new ReturnData(false,0);
        }
        return new ReturnData(true,Math.max(leftData.h,rightData.h)+1);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.left = new Node(2);
        n1.right = new Node(3);
        n1.left.left = new Node(4);
        n1.left.right = new Node(5);
        n1.right.left = new Node(6);
        n1.right.right = new Node(7);
        System.out.print("该二叉树是否为平衡二叉树： "+ isBTree(n1) );

        System.out.println();

        Node n2 = new Node(1);
        n2.left = new Node(2);
        n2.right = new Node(3);
        n2.left.left = new Node(4);
        n2.left.right = new Node(5);
        n2.right.left = new Node(6);
        n2.right.right = new Node(7);
        n2.left.left.left = new Node(8);
        n2.left.left.left.left = new Node(9);
        System.out.print("该二叉树是否为平衡二叉树： "+ isBTree(n2) );
    }
}
