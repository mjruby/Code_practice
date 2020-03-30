package fanli.selfcode.Huffmantree;
// 构造一个哈夫曼树

import java.util.Comparator;
import java.util.PriorityQueue;

public class Huffmantree {
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int value){
            this.data = value;
        }
    }

    public static class nodeComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return o1.data - o2.data;
        }
    }

    public static Node huffmanTree(int[] arr){
        PriorityQueue<Node> pQ = new PriorityQueue<>(new nodeComparator());
        for (int i : arr) {
            pQ.add(new Node(i));
        }
        while(pQ.size()>1){
            Node left = pQ.poll();
            Node right = pQ.poll();
            Node parent = new Node(left.data + right.data);
            parent.left = left;
            parent.right = right;
            pQ.offer(parent);
        }
        return pQ.poll();
    }

    // 先序遍历查看建成的 haffmanTree
    public static void preOrder(Node node){
        if(node == null) return;
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,6,7,8,13,29};
        Node node = huffmanTree(arr);
        preOrder(node);
    }
}
