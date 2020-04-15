package leetcode;
// 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//k 是一个正整数，它的值小于或等于链表的长度。
//
//如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//示例：
//
//给你这个链表：1->2->3->4->5
//当 k = 2 时，应当返回: 2->1->4->3->5
//当 k = 3 时，应当返回: 3->2->1->4->5


public class K个一组翻转链表 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(4);
        n1.next.next.next.next = new ListNode(5);
        n1.next.next.next.next.next = new ListNode(6);

        printList(n1);
        ListNode head = reverseKGroup(n1,3);
        printList(head);

        System.out.println("++++++++++++++++++++++");
        printList(reverseKGroup(null,1));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre != null){
            int i = 0;
            ListNode last = pre;
            while(i <= k && last != null){
                last = last.next;
                i++;
            }
            if( i < k+1) return dummy.next;  // && last.next != null
            else {
                ListNode tail = pre.next;
                ListNode cur = pre.next.next;
                while (cur != last){
                    ListNode next = cur.next;
                    cur.next = pre.next;
                    pre.next = cur;
                    tail.next = next;
                    cur = next;
                }
                pre = tail;
            }
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
