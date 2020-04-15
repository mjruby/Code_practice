package leetcode;
// 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
//示例:
//
//输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6

import java.util.Comparator;
import java.util.PriorityQueue;

public class 合并K个排序链表 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(5);

        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(3);
        n2.next.next = new ListNode(4);

        ListNode n3 = new ListNode(2);
        n3.next = new ListNode(6);

        ListNode n4 = null;

        ListNode[] lists = new ListNode[]{n1,n2,n3,n4};

        ListNode head = mergeKLists(lists);
        printList(head);

    }

    static class Min_Comparator implements Comparator<ListNode>{
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Min_Comparator());
        int len = lists.length;
        for (int i = 0; i < len; i++) {
            if(lists[i] != null){   // 这里需要注意
                pq.add(lists[i]);
            }
        }

        ListNode cur = null;
        ListNode dummy = new ListNode(0);
        ListNode curNode = dummy;
        while ((cur = pq.poll())!=null){
            curNode.next = cur;
            curNode = curNode.next;
            if(cur.next != null){
                pq.add(cur.next);
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

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
 }
}
