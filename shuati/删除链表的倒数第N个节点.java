package leetcode;
// 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
//示例：
//
//给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.

public class 删除链表的倒数第N个节点 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
//        n1.next = new ListNode(2);
//        n1.next.next = new ListNode(3);
//        n1.next.next.next = new ListNode(4);
//        n1.next.next.next.next = new ListNode(5);
//        n1.next.next.next.next.next = new ListNode(6);
        printList(n1);
        printList(removeNthFromEnd(n1,1));

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(n>0){
            fast =fast.next;
            n--;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void printList(ListNode head){
        while (head != null){
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}





