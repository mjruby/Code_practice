package primary.soursefour.selfcode;

import javax.print.DocFlavor;
import java.util.LinkedList;
import java.util.Queue;

// 介绍二叉树的序列化和反序列化
public class SerializeAndReconstructTree {
    public static class Node{
        public Integer data;
        public Node left;
        public Node right;

        public Node(Integer value){
            this.data = value;
        }
    }

    public static String serialByPreOrder(Node head){
        if(head == null) return "#!";
        String res = head.data + "!";
        res += serialByPreOrder(head.left);
        res += serialByPreOrder(head.right);
        return res;
    }

    // 将string用！切分好，放入queue,然后再递归构造
    public static Node reconSerialByPreString(String res){
        String[] arr = res.split("!");
        Queue<String> queue = new LinkedList<>();
        for (String s : arr) {
            queue.offer(s);
        }
        return reconSerialByPre(queue);
    }

    public static Node reconSerialByPre(Queue<String> queue){
        String value = queue.poll();  // 必须这样，保证遇到#既抛出了，有让递归结束
        if(value.equals("#"))  return null;
        Node head = new Node(Integer.valueOf(value));
        head.left = reconSerialByPre(queue);
        head.right = reconSerialByPre(queue);
        return head;
    }


    public static String serialByLevel(Node head){
        if( head == null) return null;
        Queue<Node> que = new LinkedList<>();
        que.offer(head);
        String res = head.data+"!";
        Node tmp;
        while(!que.isEmpty()){
            tmp = que.poll();
            if( tmp.left != null){
                que.offer(tmp.left);
                res += tmp.left.data+"!";
            }
            if( tmp.right != null){
                que.offer(tmp.right);
                res += tmp.right.data+"!";
            }
            if(tmp.left == null){
                res += "#!";
            }
            if(tmp.right == null){
                res += "#!";
            }
        }
        return res;
    }

    public static Node reconByLevelString(String str){
        String[] arr = str.split("!");
        Queue<Node> queue = new LinkedList<>();
        int i = 0 ;
        Node start = new Node(Integer.valueOf(arr[i++]));
        Node head = start;
        queue.offer(head);
        while(!queue.isEmpty()){
            head = queue.poll();
            if(arr[i].equals("#")) {
                head.left = null;
                i++;
            }
            else{
                head.left = new Node(Integer.valueOf(arr[i++]));
                queue.offer(head.left);
            }
            if(arr[i].equals("#")) {
                head.right = null;
                i++;
            }
            else{
                head.right = new Node(Integer.valueOf(arr[i++]));
                queue.offer(head.right);
            }
        }
        return start;
    }
    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.left = new Node(2);
        n1.right = new Node(3);
        n1.left.left = new Node(4);
        n1.left.right = new Node(5);
        n1.right.left = new Node(6);
        n1.right.right = new Node(7);
        Node n2 = n1;

        System.out.println("按中序遍历的顺序序列化：");
        System.out.println(serialByPreOrder(n1)); // 1!2!4!#!#!5!#!#!3!6!#!#!7!#!#!
        System.out.println("反序列化为：");
        Node n3 = reconSerialByPreString(serialByPreOrder(n1));
        System.out.println(n3.right.data);  // 3
        System.out.println(n3.right.right.data); // 7

        System.out.println("按层次序列化：");
        System.out.println(serialByLevel(n2)); // 1!2!3!4!5!6!7!#!#!#!#!#!#!#!#!
        Node n4 = reconByLevelString(serialByLevel(n2));
        System.out.println(n4.left.data);  // 2
        System.out.println(n4.left.left.data); // 4
        System.out.println(n4.left.right.data); // 5

    }
}
