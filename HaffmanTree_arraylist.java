package fanli.selfcode.Huffmantree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// 使用arraylist
public class HaffmanTree_arraylist {

    public static Node haffmanTree(int[] arr){
        ArrayList<Node>  list = new ArrayList<>();
        for (int num : arr) {
            list.add(new Node(num));
        }
        Collections.sort(list);
//        System.out.println(list); // 打印出列表里面的元素，打印格式是Node类中toString定义的
        while(list.size() > 1){
            Node left = list.get(0);
            Node right = list.get(1);
            Node parent = new Node(left.data + right.data);
            parent.left = left;
            parent.right = right;
            list.remove(left);
            list.remove(right);
            list.add(parent);
            Collections.sort(list);
        }
        return list.get(0);
    }

    public static void preOrder(Node node){
        if(node == null) return;
        node.preOrder(node);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,6,7,8,13,29};
        preOrder(haffmanTree(arr)); // 67 29 38 15 7 8 23 10 4 1 3 6 13

        System.out.println();
        int[] arr1 = new int[]{9,5,1,4,1,2,5,1,2,4,4,2};
        preOrder(haffmanTree(arr1)); // 40 17 8 4 4 2 2 9 23 10 5 5 13 5 2 1 1 3 1 2 8 4 4
    }
}



class Node implements Comparable<Node>{
    int data;
    Node left;
    Node right;
    public Node(int value){
        this.data = value;
    }
    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
    @Override
    public int compareTo(Node o) {
        return this.data -o.data;
    }

    // 一个先序遍历的函数
    public void preOrder(Node node){
        if(node == null) return;;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
}