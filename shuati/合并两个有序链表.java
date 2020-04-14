package leetcode;

import java.util.List;

// 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
//示例：
//
//输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
public class 合并两个有序链表 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(5);

        ListNode n2 = new ListNode(3);
        n2.next = new ListNode(4);
        n2.next.next = new ListNode(6);
        n2.next.next.next = new ListNode(7);

        printList(n1);
        printList(n2);
        printList(mergeTwoLists(n1,n2));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null ) return l2;
        if(l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            cur.next = l1.val < l2.val? l1:l2;
            cur = cur.next;
            if(l1.val < l2.val){
                l1 = l1.next;
            }else {
                l2 = l2.next;
            }
        }
        if(l1 != null){
            cur.next = l1;
        }
        if(l2 != null){
            cur.next = l2;
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

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
