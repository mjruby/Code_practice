package offer;

import javax.swing.*;
import java.util.HashMap;
import java.util.Random;

// 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
// 另一个特殊指针random指向一个随机节点），
// 请对此链表进行深拷贝，并返回拷贝后的头结点。
// （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
public class 复杂链表的复制 {
    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        node1.next = node2;node2.next=node3;node3.next=node4;
        node1.random = node3;node2.random=node1;node3.random=node1;node4.random=node3;
        RandomListNode clone = Clone(node1);
        System.out.println(clone.random.next.label);

    }


    // other：借助map
    public static RandomListNode Clone1(RandomListNode pHead) {
        if(pHead == null) return pHead;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode p = pHead;
        // 克隆新结点
        while( p != null){
            RandomListNode newNode = new RandomListNode(p.label);
            map.put(p,newNode);
            p = p.next;
        }
        // 克隆对应关系
        p = pHead;
        while(p != null){
            RandomListNode newNode = map.get(p);
            newNode.next = map.get(p.next);  // p.next可能为null,可以考虑下。因为hashMap中可以存放null，所以这里也对
            newNode.random = map.get(p.random);
            p = p.next;
        }
        return map.get(pHead);
    }

    // other: 不使用map,直接克隆结点加入原链表，然后拆分
    public static RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) return pHead;
        // 遍历1，将克隆结点加入原结点后面
        RandomListNode p = pHead;
        while(p != null){
            RandomListNode newNode = new RandomListNode(p.label);
            newNode.next = p.next;
            p.next = newNode;
            p = newNode.next;
        }
        // 遍历2，克隆随机指针【random指针可能为空，要考虑否则会出现空指针异常错误】
        p = pHead;
        while(p != null){
            RandomListNode newNode = p.next;
//            newNode.random = p.random.next;
            newNode.random = p.random==null?null:p.random.next;
            p = newNode.next;
        }
        // 遍历3，拆分出原链表和克隆链表
        RandomListNode cloneHead = pHead.next;
        RandomListNode cloneNode = cloneHead;
        RandomListNode node = pHead;
        while(node != null){
            node.next = node.next.next;
//          cloneNode.next = cloneNode.next.next; // 最后一个cloneNode，没有next.next,会出现空指针异常
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
            node = node.next;
            cloneNode = cloneNode.next;
        }
        return cloneHead;
    }

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
