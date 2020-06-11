package offer;

// 点评: 看着简单，做着难

import java.util.List;


// 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
// 重复的结点不保留，返回链表头指针。
// 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
public class 删除链表中重复的结点 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(3);
        node.next.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next.next.next = new ListNode(5);
        printLinkNode(node);
        ListNode newnode = deleteDuplication(node);
        printLinkNode(newnode);
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null) return pHead;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode tmp = pHead;
        while(tmp != null){
            int val = tmp.val;
            if(tmp.next == null || tmp.next.val != val){
                cur.next = tmp;
                cur = cur.next;
                tmp = tmp.next;
            }else{
                while(tmp.next != null && tmp.next.val == val){
                    tmp = tmp.next;
                }
                tmp = tmp.next == null ? null : tmp.next;
            }
        }
        cur.next = null;  // 注意，记得要给封上，要不加上的最后一个符合要求的结点，它后面的结点也会带上了，出错
        return dummy.next;
    }

    public static void printLinkNode(ListNode root){
        while(root!= null){
            System.out.print(root.val+"-->");
            root = root.next;
        }
        System.out.println();
    }
}
