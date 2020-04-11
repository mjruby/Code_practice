package offer;

import java.util.ArrayList;
import java.util.Stack;

// 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
public class 从尾到头打印链表 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);

        ArrayList<Integer> al = printListFromTailToHead(n1);
        System.out.println(al);

        ArrayList<Integer> test = new ArrayList<>();
        System.out.println(test);
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        if(listNode == null) return null;
        ArrayList<Integer> arrList = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        ListNode curNode = listNode;
        while(curNode!=null){
            st.add(curNode.val);
            curNode = curNode.next;
        }
        while(st.size() > 0){
            arrList.add(st.pop());
        }
        return arrList;
    }

}


//class ListNode{
//    int data;
//    ListNode next;
//
//    public ListNode(int value){
//        this.data = value;
//    }
//}



class ListNode {
     int val;
     ListNode next = null;

     ListNode(int val) {
         this.val = val;
     }
 }

