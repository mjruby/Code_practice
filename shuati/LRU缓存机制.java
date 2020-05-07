package leetcode;
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
//

import java.util.HashMap;

// 思路： 双向链表 + 哈希表
public class LRU缓存机制 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));;       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));;       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));;       // 返回 -1 (未找到)
        System.out.println(cache.get(3));;       // 返回  3
        System.out.println(cache.get(4));;       // 返回  4
    }



}


class LRUCache {
    public HashMap<Integer,Node> map;
    public DoubleLink db;
    public int capability;
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.db = new DoubleLink();
        this.capability = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            int data = map.get(key).val;
            put(key,data);
            return data;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node x = new Node(key,value);  // 一定记得只会new一个对象，这样map里和db里存储的才是同一个结点
        if(map.containsKey(key)){
            Node getNode = map.get(key);
            db.remove(getNode);
            db.addFirst(x);
            map.put(key,x);
        }else {
            if(db.size() == capability){
                Node lastNode = db.removeLast();
                map.remove(lastNode.k);
            }
            db.addFirst(x);
            map.put(key,x);
        }
    }
}


class DoubleLink {
    Node first; // 伪结点 dummy
    Node last;
    int size;  // 记录双向链表大小

    public DoubleLink(){
        this.first = new Node(0,0); // 伪结点 dummy
        this.last = new Node(0,0);
        first.next = last;   // *** 首尾建立好联系
        last.pre = first;
        size = 0;
    }
    // 删除最后一个结点
    public Node removeLast(){
        if(first.next == last) return null;
        Node tmp = last.pre;
        Node pre = last.pre.pre;
        pre.next = last ;
        last.pre = pre;
        size--;
        return tmp;
    }
    // 删除指定结点(一定有)
    public void remove(Node node){
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
        size--;
    }
    // 首部添加一个结点
    public void addFirst(Node node){
        Node firstNode = first.next;
        first.next = node;
        node.next = firstNode;
        node.pre = first;
        firstNode.pre = node;
        size++;

//        node.next = first.next;
//        node.pre = first;
//        first.next.pre = node;
//        first.next = node;
//        size++;
    }

    // 返回规格
    public int size(){
        return this.size;
    }
}

class Node{
    int k,val;
    Node pre,next;
    public Node(int k,int val){
        this.k = k;
        this.val = val;
    }
}