package leetcode;
// 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 
// 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
//如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
//您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//

import java.util.LinkedList;

// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
public class 两数相加 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(3);

        ListNode n2 = new ListNode(5);
        n2.next = new ListNode(6);
        n2.next.next = new ListNode(4);

        printList(n1);
        printList(n2);
        printList(addTwoNumbers(n1,n2));

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1.next;
        ListNode p2 = l2.next;
        ListNode sumNode = new ListNode((l1.val+l2.val)%10);
        int carry = (l1.val+l2.val)/10;
        ListNode cur = sumNode;
        int tmp = 0;
        while(p1 != null && p2!= null){
            tmp = p1.val+p2.val+carry;
            carry = tmp / 10;
            cur.next = new ListNode(tmp % 10);
            cur = cur.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        while(p1 != null){
            tmp = p1.val + carry;
            carry = tmp/10;
            cur.next = new ListNode(tmp % 10);
            cur = cur.next;
            p1 = p1.next;
        }
        while(p2 != null){
            tmp = p2.val + carry;
            carry = tmp/10;
            cur.next = new ListNode(tmp % 10);
            cur = cur.next;
            p2 = p2.next;
        }
        if(carry != 0){
            cur.next = new ListNode(carry);
        }
        return sumNode;
    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val +"  ");
            head = head.next;
        }
        System.out.println();
    }

}

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}
