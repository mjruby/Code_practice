package offer;

import leetcode.test;

//输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
public class 合并两个排序的链表 {
    public static void main(String[] args) {
        ListNode ls1 = new ListNode(1);
        ls1.next = new ListNode(3);
        ls1.next.next = new ListNode(5);

        ListNode ls2  = new ListNode(2);
        ls2.next = new ListNode(3);
        ls2.next.next = new ListNode(6);
        ls2.next.next.next = new ListNode(8);

        printLinkedList(ls1);
        printLinkedList(ls2);
        ListNode rs = Merge(ls1, ls2);
        printLinkedList(rs);
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (p1 != null && p2 != null) {
            if(p1.val <= p2.val){
                cur.next = p1; p1 = p1.next;
            }else {
                cur.next = p2; p2 = p2.next;
            }
            cur = cur.next;
        }
        cur.next = p1 != null ? p1:p2;
        return dummy.next;
    }

    // 打印链表
    public static void printLinkedList(ListNode head){
        while(head != null){
            System.out.print(head.val + " --> ");
            head = head.next;
        }
        System.out.println();
    }
}
