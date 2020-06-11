package offer;
// 输入一个链表，输出该链表中倒数第k个结点。
public class 链表中倒数第k个结点 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
//        node.next.next.next.next.next = new ListNode(4);
        System.out.println(FindKthToTail(node,6));
    }

    public static ListNode FindKthToTail(ListNode head,int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy;
        ListNode right = dummy;
        while(right!=null && k>0){
            right = right.next;
            k--;
        }
        if(k != 0 || right == null) return null;  // 这里要注意right==null也说明了k超出链表长度
        while (right != null){
            right = right.next;
            left = left.next;
        }
        return left;
    }
}


//    ListNode left = head;
//    ListNode right = head;
//        while(right!=null && k>0){
//                right = right.next;
//                k--;
//                }
//                if(k != 0) return null;
//                while (right != null){
//                right = right.next;
//                left = left.next;
//                }
//                return left;