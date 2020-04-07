package fanli.selfcode.linkedList;

import javax.imageio.ImageTranscoder;
import java.util.ArrayList;
import java.util.Arrays;

public class ReverseList {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        printList(n1);
        System.out.println("链表反转后结果为：");
        printList(reverseList(n1));

    }

    public static void printList(Node head){
        if(head == null) return;
        while(head!=null){
            System.out.print(head.data +"  ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node reverseList(Node head){
        if(head == null || head.next == null) return head;
        Node pre = null;
        Node tmp = null;
        while(head != null){
            tmp = head;
            head = head.next;
            tmp.next = pre;
            pre = tmp;
        }
         return pre;
    }
}


class Node{
    int data;
    Node next;
    public Node(int value){
        this.data = value;
    }
}