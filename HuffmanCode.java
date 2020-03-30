package fanli.selfcode.huffmancode;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

// i like like like java do you like a java
// 使用huffmantree 构造出前缀码，完成huffman编码

// 关键是构造huffumanCode 的递归函数
public class HuffmanCode {

    // 统计好一个字符串中，各字符出现的频率
    public static HashMap<Character, Integer> getCharWeight(String str){
        if(str == null) return null;
        HashMap<Character,Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (Character member : chars) {
            if(map.containsKey(member)){
                map.put(member,map.get(member)+1);
            }else{
                map.put(member,1);
            }
        }
       return map;
    }

    public static Node huffmanTree(HashMap<Character, Integer> map){
        if ( map == null) return null;
        LinkedList<Node> list = new LinkedList<>();
        Set<Character> charSet = map.keySet();
        for (Character c : charSet) {
            list.add(new Node(c,map.get(c)));
        }
        Collections.sort(list);
        while (list.size() > 1){
            Node left = list.get(0);
            Node right = list.get(1);
            Node parent = new Node(null,left.w+right.w);
            parent.left = left;
            parent.right = right;
            list.add(parent);
            list.remove(left);
            list.remove(right);
            Collections.sort(list);
        }
        return list.get(0);
    }

    // 先序打印Node
    public static void preOrder(Node node){
        if(node == null) return;
        node.preOrder();
    }

    static HashMap<Character,String> huffmanCode = new HashMap<>();
    // huffman 编码，要用到递归  ******************
    // node -- 到某个结点    c -- 到结点node的路径上的字符，往左为0，往右为1，
    // sb -- 代表到结点node的前一个结点为止经过的路径字符串
    public static void huffmanCode(Node node, Character c, StringBuilder sb){
        StringBuilder ssb = new StringBuilder(sb);
        if(c == null) {
            ssb.append("");
        }else {
            ssb.append(c);
        }
        if(node.data != null){
            huffmanCode.put(node.data,ssb.toString());
        }else{
            huffmanCode(node.left,'0',ssb);
            huffmanCode(node.right,'1',ssb);
        }

//   错误
//        if(c == null) {
//            sb.append("");
//        }else {
//            sb.append(c);
//        }
//        if(node.data != null){
//            huffmanCode.put(node.data,sb.toString());
//        }else{
//            huffmanCode(node.left,'0',sb);
//            huffmanCode(node.right,'1',sb);
//        }
    }
    public static void getHuffmanCode(HashMap<Character,String> map){
        Set<Character> codes = map.keySet();
        for (Character code : codes) {
            System.out.println(code+ " --> "+map.get(code));
        }
    }

    public static void main(String[] args) {
//        String str = " I love";
//        byte[] bytes = str.getBytes();
//        char[] chars = str.toCharArray();
//        for (char aChar : chars) {
//            System.out.print(aChar+" - ");  // - I -   - l - o - v - e -
//        }
//        for (byte aByte : bytes) {
//            System.out.print(aByte+" "); // 32 73 32 108 111 118 101
//        }

//        // StringBuilder
//        StringBuilder sb1 = new StringBuilder();
//        sb1.append("i");
//        sb1.append('v');
//        sb1.append("   ");
//        sb1.append(1);
//        System.out.println(sb1); // iv   1
//        System.out.println(sb1.toString()); // iv   1
//
//        StringBuilder sb2 = new StringBuilder(sb1);
//        sb2.append("I like China");
//        System.out.println(sb2); // iv   1I like China

        String str = "i like like like java do you like a java";
        HashMap<Character, Integer> charWeight = getCharWeight(str);
        // 遍历下
        for (Character c : charWeight.keySet()) {
            System.out.println(c +" --> " + charWeight.get(c));
        }
        System.out.println("============================================");
        // 构造哈夫曼树
        Node node = huffmanTree(charWeight);
        preOrder(node);
        System.out.println("============================================");
        // 构造哈夫曼编码
        StringBuilder sb = new StringBuilder();
        huffmanCode(node,null,sb);
        getHuffmanCode(huffmanCode);
    }
}


class Node implements Comparable<Node>{
    Character data; // 存放字符,a,b,c,...
    Integer w; // 权重 , 这里是每种字符出现的次数
    Node left;
    Node right;

    public Node(Character data, int w){
        this.data = data;
        this.w = w;
    }

    public void preOrder(){
        System.out.println("weight = "+this.w + " , char = " +this.data);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", w=" + w +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.w - o.w;
    }
}