package offer;
// 输入一个链表，反转链表后，输出新链表的表头。

import java.util.List;

public class 反转链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(7);
        head.next.next = new ListNode(3);
        printLinkedList(head);
        ListNode newHead = ReverseList(head);
        printLinkedList(newHead);
    }

    public static ListNode ReverseList(ListNode head) {
        if(head == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;
        while(cur != null){
            cur.next = pre;
            pre = cur;
            cur = next;
            if(next != null) next = next.next;
        }
        return pre;
    }


    public static void printLinkedList(ListNode head){
        while(head != null){
            System.out.print(head.val + " --> ");
            head = head.next;
        }
        System.out.println();
    }
}



