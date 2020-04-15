package leetcode;
// 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//示例:
//
//给定 1->2->3->4, 你应该返回 2->1->4->3.

public class 两两交换链表中的节点 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(4);
        n1.next.next.next.next = new ListNode(5);
        printList(n1);

        ListNode head = swapPairs(n1);
        printList(head);
    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tmp = null;
        ListNode next = null;
        while(pre.next != null && pre.next.next!= null){
            tmp = pre.next;
            next = tmp.next.next;
            pre.next = tmp.next;
            pre.next.next = tmp;
            tmp.next = next;
            pre = tmp;
        }
        return dummy.next;
    }


    public static void printList(ListNode head){
        while (head != null){
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
