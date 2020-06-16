package offer;
// 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。

import java.util.List;

// 【关键】 同起步，相遇则有环； 快从头，快慢同速，相遇即为环入口
public class 链表中环的入口结点 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);

        node1.next = node2;
        node2.next = node1;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//        node7.next = node8;
//        node8.next = node9;
//        node9.next = node2;
        System.out.println(EntryNodeOfLoop(node1)==null?null:EntryNodeOfLoop(node1).val);
    }

    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) return null;
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break; // 有环
        }
        if(fast == null || fast.next == null) return null;
        fast = pHead;  // fast返回起点
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
            if (slow == fast)  return slow;
        }
        return pHead;  // 整个都是个环的情况
    }
}
