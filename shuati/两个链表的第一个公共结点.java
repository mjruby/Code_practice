package offer;
// 输入两个链表，找出它们的第一个公共结点。
// （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
public class 两个链表的第一个公共结点 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n1.next = n2;n2.next =n3;n3.next=n4;
        n5.next = n6;n6.next =n7;//n7.next=n3;

        System.out.println(FindFirstCommonNode(n1,n5).val);

    }

    // 让长链先跑多余的长度，然后一起出发，会相遇在第一个结点
    public static ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        int len1 = lenList(pHead1);
        int len2 = lenList(pHead2);
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        // 走到齐平
        if(len1 > len2){
            int len = len1- len2;
            while(len>0){
                len--;
                p1 = p1.next;
            }
        }
        if(len2 > len1){
            int len = len2 - len1;
            while(len>0){
                len--;
                p2 = p2.next;
            }
        }
        // 一起出发
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static int lenList(ListNode node){
        int count = 0;
        while(node!=null){
            count++;
            node = node.next;
        }
        return count;
    }


    // other: 直接没看懂，debug一下
    // p1遍历路径是：1,2,3,4,5,6,7,3,4  p2遍历路径是：5,6,7,3,4,1,2,3,4
    // 两个指针遍历的路径长度相同，如果有公共结点，则跳出while时的p1就是第一个公共结点
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null)return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
            if(p1 != p2){  //【注意】当两个链表没有公共结点，最后null 和 null判断跳出循环，否则会死循环
                if(p1 == null)p1 = pHead2;
                if(p2 == null)p2 = pHead1;
            }
        }
        return p1;
    }
}
