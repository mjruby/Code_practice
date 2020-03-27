package primary.soursefour.selfcode;

import class_04.Code_08_CompleteTreeNodeNumber;

// 已知一棵完全二叉树，求其节点的个数
// 要求：时间复杂度低于O(N)，N为这棵树的节点个数
// 最后实现的复杂度是O(（logN）^2)

// 【错误原因】 使用 << 要用括号括起来，它的优先级低
public class CompleteTreeNodeNumber {
    public static class Node{
        Integer data;
        Node left;
        Node right;

        public Node(Integer value){
            this.data = value;
        }
    }
    public static Integer mostLeftLevel(Node head,Integer level){
        // head -- 当前结点   level-- 当前结点所在的层
        while(head != null){
            level ++;
            head = head.left;
        }
        return level-1;
    }

    public static Integer CBTNumber(Node head){
        if( head == null){
            return 0;
        }
        return bs(head,1,mostLeftLevel(head,1));
    }

    public static int bs(Node head, Integer level, Integer h){
        // level -- 当前结点的高度, h -- 树的总的高度
        if(level == h){
            return 1;
        }
        if(mostLeftLevel(head.right,level+1) == h){  // 成立，左子树为满二叉树
            return (1 << (h - level))+ bs(head.right,level+1, h);
            // << 的优先级低于+，记住要（）括起来
        }else { // 右子树为满二叉树
            return (1 << (h - level -1)) + bs(head.left, level+1, h);
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.left = new Node(2);
        n1.right = new Node(3);
        n1.left.left = new Node(4);
        n1.left.right = new Node(5);

        System.out.println("完全二叉树总的结点树为：" + CBTNumber(n1));
    }
}
