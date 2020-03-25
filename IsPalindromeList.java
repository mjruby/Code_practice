package primary.coursethree.selfcode;
//判断一个链表是否为回文结构
//【题目】 给定一个链表的头节点head，请判断该链表是否为回文结构。
//        例如： 1->2->1，返回true。
//        1->2->2->1，返回true。
//        15->6->15，返回true。
//        1->2->3，返回false。
//【进阶】： 如果链表长度为N，时间复杂度达到O(N)，额外空间复杂 度达到O(1)。

import java.util.Stack;

public class IsPalindromeList {
    public static class Node{
        Integer data;
        Node next;

        public Node(Integer value){
            this.data = value;
        }
    }

    // 借助一个栈，需要额外的n个空间复杂度
    public static boolean isPalindromeList1(Node head){
        if(head == null){ return false; }
        Stack<Node> stack = new Stack<>();
        Node p = head;
        while(p != null){
            stack.push(p); p = p.next;
        }
        while(head != null){
            if(head.data != stack.peek().data){
                return false;
            }else{
                head = head.next; stack.pop();
            }
        }
        return true;
    }

    // 使用快慢指针，再借助栈，需要额外n/2的空间
    public static boolean isPalindromeList2(Node head){
        if( head == null){
            return false;
        }
        Node lp = head;
        Node fp = head;
        while(fp != null){
            lp = lp.next;
            if( fp.next == null) break;
            fp = fp.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while(lp != null){
            stack.push(lp);
            lp = lp.next;
        }
        while(!stack.isEmpty()){
            if(stack.pop().data != head.data){
                return false;
            }else{
                head = head.next;
            }
        }
        return true;
    }

    // 不借助额外空间
    public static boolean isPalindromeList3(Node head){
        // 首先找到中间点，如果是链表数是偶数则会是相同元素的后一个，如果是奇数则是中间那个
        if( head == null){
            return false;
        }
        Node lp = head;
        Node fp = head;
        while(fp != null){
            lp = lp.next;
            if( fp.next == null) break;
            fp = fp.next.next;
        }

        // 从lp(中间结点)把后面一直到null的部分链表反转
        Node tmp;
        Node pre = null;
        while(lp != null){
            tmp = lp.next;
            lp.next = pre;
            pre = lp;
            lp = tmp;
        }
        Node last = pre;
        // 分别从原链表的两端比较
        //Node node;
        while(lp != null){
            if(head.data != lp.data){
                return false;
            }else{
              //  node = lp;
                lp = lp.next;
                head = head.next;
            }
        }

        // 还原链表
        pre = null;
        while(last != null){
            tmp = last.next;
            last.next = pre;
            pre = last;
            last = tmp;
        }
        return true;
    }

    public static void printLinkedList(Node head){
        System.out.print("Linked list: ");
        if(head == null){
            return;
        }
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.next = new Node(3);
        n1.next.next = new Node(7);
        n1.next.next.next = new Node(3);
        n1.next.next.next.next = new Node(1);

        printLinkedList(n1);
        System.out.println("是否为回文链表："+ isPalindromeList1(n1));
        System.out.println("是否为回文链表："+ isPalindromeList2(n1));
        System.out.println("是否为回文链表："+ isPalindromeList3(n1));
        printLinkedList(n1);

    }


}
