package primary.coursethree.selfcode;
//打印两个有序链表的公共部分 ( 指的是有哪些相等的值 )
//【题目】 给定两个有序链表的头指针head1和head2，打印两个链表的公共部分。
public class PrintCommonPart {
    public static class Node{
        public Integer data;
        public Node next;

        public Node(Integer value){
            this.data = value;
        }
    }

    public static void printCommonPart(Node head1, Node head2){
        if(head1 == null || head2 == null){
            return;
        }
        while(head1 != null && head2 != null){
            if(head1.data == head2.data){
                System.out.print(head1.data+" ");
                head1 = head1.next;
                head2 = head2.next;
            }else if(head1.data < head2.data){
                head1 = head1.next;
            }else{
                head2 = head2.next;
        }
        }
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
        n1.next  = new Node(3);
        n1.next.next = new Node(7);
        n1.next.next.next = new Node(9);
        n1.next.next.next.next = new Node(11);
        printLinkedList(n1);

        Node n2 = new Node(4);
        n2.next = new Node(5);
        n2.next.next = new Node(7);
        n2.next.next.next = new Node(11);
        printLinkedList(n2);

        System.out.print("公共部分的值有：");
        printCommonPart(n1,n2);

    }
}
