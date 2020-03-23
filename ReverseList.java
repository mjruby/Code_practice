package primary.coursethree.selfcode;
//反转单向和双向链表
//【题目】 分别实现反转单向链表和反转双向链表的函数。
//【要求】 如果链表长度为N，时间复杂度要求为O(N)，额外空间复杂度要求为O(1)
public class ReverseList {

    public static class Node{
        public Integer data;
        public Node next;

        public Node(Integer value){
            this.data = value;
        }
    }
    
    public static Node reverseList(Node head){
        Node curHead = null;
        Node curPre = null;
        while(head != null){
            curHead = head.next;
            head.next = curPre;
            curPre = head;
            head = curHead;
        }
        return curPre;
    }

    public static class DoubleNode{
        public Integer data;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(Integer value){
            this.data = value;
        }

    }
    public static DoubleNode reverseDoubleList(DoubleNode head){
        DoubleNode curHead = null;
        DoubleNode curPre = null;
        while(head != null){
            curHead = head.next;
            head.last = curHead;
            head.next = curPre;
            curPre = head;
            head = curHead;
        }
        return curPre;
    }

    public static void printList(Node head){
        while(head != null){
            System.out.print(head.data);
            head = head.next;
        }
    }

    public static void printDoubleList(DoubleNode head){
        DoubleNode end = null;
        while(head != null){
            System.out.print(head.data);
            end = head;
            head = head.next;
        }
        System.out.print(" | ");
        while(end != null){
            System.out.print(end.data);
            end = end.last;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n3.next = new Node(4);
        n1.next = n2;
        n2.next = n3;
        printList(n1);
        System.out.println();
        printList(reverseList(n1));

        System.out.println();
        System.out.println("=================================");
        DoubleNode d1 = new DoubleNode(5);
        DoubleNode d2 = new DoubleNode(3);
        DoubleNode d3 = new DoubleNode(7);
        DoubleNode d4 = new DoubleNode(8);
        d1.next = d2;
        d2.next = d3; d2.last = d1;
        d3.next = d4; d3.last = d2;
        d4.last = d3;

        printDoubleList(d1);
        System.out.println();
        printDoubleList(reverseDoubleList(d1));
    }
}
