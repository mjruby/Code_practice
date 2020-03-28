package primary.coursefive.selfcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// 认识并查集结构
public class UnionFind {

    public static class Node{
        Integer data;

        public Node(Integer value){
            this.data = value;
        }
    }

    public static class UnionFindSet{
        HashMap<Node,Node> fatherMap ;
        HashMap<Node,Integer> sizeMap ;
        public UnionFindSet(List<Node> list){
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (Node node : list) {
                fatherMap.put(node,node);
                sizeMap.put(node,1);
            }
        }

        public Node findHead(Node node){
            Node father = fatherMap.get(node);
            if(father != node){
                father = fatherMap.get(father);
            }
            fatherMap.put(node,father);  // 优化。在查找head结点时，把这条路上所有点都直接挂在head上
            return father;
        }

        public Boolean isSameSet(Node node1,Node node2){
            return findHead(node1) == findHead(node2);
        }

        public void union(Node a,Node b){
            if(a == null || b == null){
                return;
            }
            int aSize = sizeMap.get(findHead(a));
            int bSize = sizeMap.get(findHead(b));
            if(aSize > bSize){
                fatherMap.put(b,a);
                sizeMap.put(a,(aSize+bSize));
            }else{
                fatherMap.put(b,a);
                sizeMap.put(b,(aSize+bSize));
            }
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
//        Node n5 = new Node(5);
//        Node n6 = new Node(6);
//        Node n7 = new Node(7);
//        Node n8 = new Node(8);
        List<Node> list1 = List.of(n1, n2, n3, n4);
//        List<Node> list2 = List.of(n5, n6, n7, n8);

        UnionFindSet a = new UnionFindSet(list1);
//        UnionFindSet b = new UnionFindSet(list2);

        System.out.println("1 和 3 是否属于同一个集合："+ a.isSameSet(n1,n3)); // false
        a.union(n1,n3);
        System.out.println("1 和 3 是否属于同一个集合："+ a.isSameSet(n1,n3)); // true
        a.union(n1,n4);
        System.out.println("3 和 4 是否属于同一个集合："+ a.isSameSet(n3,n4)); // true
        System.out.println("2 和 1 是否属于同一个集合："+ a.isSameSet(n2,n1)); // false


    }
}


