package primary.coursethree.selfcode;

import class_03.Code_12_SmallerEqualBigger;

// 将单向链表按某值划分成左边小、中间相等、右边大的形式
public class SmallerEqualBigger {

    public static class Node{
        public Integer data;
        public Node next;

        public Node(Integer value){
            this.data = value;
        }
    }

    // 将小于，等于，大于区域分为三个小链表，然后连接即可
    public static Node smallerEqualBigger2(Node head, Integer num){
        if(head == null){
            return null;
        }
        Node sT = null;
        Node sD = null;
        Node eT = null;
        Node eD = null;
        Node bT = null;
        Node bD = null;

        Node next = null;
        while( head != null){
            next = head.next;
            head.next = null;
//            System.out.println("head:"+head.data);
//            System.out.println("next:"+next.data);
            if(head.data < num){
                if(sT == null){sT = head; sD = head;}
                else {
                    sD.next = head;
                    sD = head;
//                    sD = sD.next;
                }
            }else if(head.data == num){
                if(eT == null){ eT = head; eD = head;}
                else{
                    eD.next = head;
                    eD = head;
//                    eD = eD.next;
                }
            }else {
                if(bT == null){ bT = head; bD = head;}
                else{
                    bD.next = head;
                    bD = head;
//                    bD = bD.next;
                }
            }
            head = next;
        }

        // 老师写的错了，因为我的例子放进去验证它是错的
        if(sT != null){  // s不为空，开头的所有情况
            sD.next = eT;
            eD = eT != null? eD:sD;

            if(bT != null){
                eD.next = bT;
            }
        }else if(eT != null){  // s 为空，e 不为空开头的所有情况
            eD.next = bT;
        }

        return sT != null? sT: eT != null? eT:bT;
    }

    // 将链表保存到数组，排序完再连接成链表形式
    public static Node smallerEqualBigger1(Node head, Integer num){
        if( head == null){
            return null;
        }
        int len = 0;
        Node tmp = head;
        while (tmp != null){
            tmp = tmp.next; len++;
        }
        Node[] arr = new Node[len];
        // 将结点放进数组
        while(head != null){
            arr[--len] = head;
            head = head.next;
        }
        partition(arr,num);

        int i;
        for (i = 1; i != arr.length; i++) {
            arr[i - 1].next = arr[i];
        }
        arr[i - 1].next = null;     // 最重要的是最后要加上 null ;否则真的是循环输出。
        return arr[0];


//        自己写的，改好了，不过还是上面老师的方便理解
//        Node sortList = arr[0];
//        int i;
//        for (i = 1; i < arr.length-1; i++) {
//            sortList.next = arr[i];
//            sortList = sortList.next;
//        }
//        sortList.next = arr[i];
//        sortList.next.next = null;
//
//        return arr[0];
    }

    public static void partition(Node[] arr,Integer num){
        int less = -1;
        int more = arr.length;
        int cur = 0;
        while(cur < more){
            if(arr[cur].data < num){
                swap(arr,++less,cur++);
            }else if(arr[cur].data > num){
                swap(arr,--more,cur);
            }else{
                cur++;
            }
        }
    }

    public static void printLinkedList(Node head){
        if(head == null){
            return;
        }
        while(head != null){
            System.out.print( head.data+" ");
            head = head.next;
        }
        System.out.println();
    }

    public static void swap(Node[] arr, int i,int j){
        Node tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Node n1 = new Node(3);
        n1.next = new Node(5);
        n1.next.next = new Node(1);
        n1.next.next.next = new Node(7);
        n1.next.next.next.next = new Node(2);
        Integer value = 5;
        System.out.println("本来的顺序是：");
        printLinkedList(n1);

        Node n2 = smallerEqualBigger1(n1,value);
        printLinkedList(n2);

        System.out.println("===================================================");
        Node n3 = new Node(3);
        n3.next = new Node(5);
        n3.next.next = new Node(1);
        n3.next.next.next = new Node(7);
        n3.next.next.next.next = new Node(2);

        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);

        System.out.println("本来的顺序是：");
        printLinkedList(head1);
        Node n4 = smallerEqualBigger2(head1,value);
        printLinkedList(n4);

    }
}
