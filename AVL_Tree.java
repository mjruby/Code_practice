package fanli.selfcode.avl;
// ���� AVL����ƽ�������������

import com.sun.source.tree.NewArrayTree;

public class AVL_Tree {
    public static void main(String[] args) {
//        Node n1 = new Node(1);
//        n1.left = new Node(2);
//        n1.left.right = new Node(3);
//        n1.right = new Node(4);
//        System.out.println(n1.nodeHeight());

//        int[] arr = new int[]{4,3,6,5,7,8};
//        int[] arr = new int[]{10,12,8,9,7,6};
        int[] arr = new int[]{10,11,7,6,8,9};   // �������������ӣ���Ҫ˫��ת����ʹ��ƽ��
//        int[] arr = new int[]{2,1,6,5,7,3};
        AVLTree avlTree = new AVLTree();
        for (int num : arr) {
            avlTree.add(new Node(num));
        }
        System.out.println("ƽ�������������ߣ�"+ avlTree.getRoot().left.nodeHeight());
        System.out.println("ƽ�������������ߣ�"+ avlTree.getRoot().right.nodeHeight());
        avlTree.inOrder_AVL();

    }
}

class AVLTree{
    Node root;

    public Node getRoot(){
        return root;
    }

    public void add(Node node){
        if(root == null){
            root = node;
        }else {
            root.addNode(node);
            this.root = adjust_AVLTree(root);
        }
    }

    // �������������Ǹ���㣬�����µĸ����
    public Node adjust_AVLTree(Node root) {
        if(root.left != null && root.right != null){
            if ((root.left.nodeHeight() - root.right.nodeHeight()) > 1) { // ����ת
                if(root.left.right.nodeHeight() > root.left.left.nodeHeight()){// ������������һ��
                    Node subLeftRotate = root.left;
                    Node tmp = subLeftRotate.right;
                    subLeftRotate.right = tmp.left;
                    tmp.left = subLeftRotate;
                    root.left = tmp;
                }
                Node tmp = root.left;
                root.left = tmp.right;
                tmp.right = root;
                return tmp; // �µĸ��ڵ�
            } else if ((root.right.nodeHeight() - root.left.nodeHeight()) > 1) { // ����ת
                if(root.right.left.nodeHeight() > root.right.right.nodeHeight()){ // ��������һ��
                    Node subRightRotate = root.right;
                    Node tmp = subRightRotate.left;
                    subRightRotate.left = tmp.right;
                    tmp.right = subRightRotate;
                    root.right = tmp;
                }
                Node tmp = root.right;
                root.right = tmp.left;
                tmp.left = root;
                return tmp;
            } else {
                return root;
            }
        }else{
            if(root.left == null && root.right != null){
                if(root.right.nodeHeight() > 1){  // ����ת
                    Node tmp = root.right;
                    root.right = tmp.left;
                    tmp.left = root;
                    return tmp;
                }
            }else if(root.right == null && root.left != null){
                if(root.left.nodeHeight() > 1){ // ����ת
                    Node tmp = root.left;
                    root.left = tmp.right;
                    tmp.right = root;
                    return tmp; // �µĸ��ڵ�
                }
            }else {
                return root;
            }
        }
        return root;
    }

    public void inOrder_AVL(){
        if(root == null) return;
        else{
            root.inOrder();
        }
    }

}



class Node{
    Integer data;
    Node left;
    Node right;
    Node parent;

    public Node(Integer value){
        this.data = value;
    }

    // ��ӽ�� �ݹ�
    public void addNode(Node node){
        if(node == null) return;
        if(node.data < this.data){
            if(this.left == null){
                this.left = node;
                node.parent = this;
            }else {
                this.left.addNode(node); // ��leftΪ�����ȥ����µĽ��
            }
        }else {
            if(this.right == null){
                this.right = node;
                node.parent = this;
            }else{
                this.right.addNode(node);
            }
        }


    }

    // �ҵ�Ҫɾ���Ľ��
    public Node searchNode(int data){
        if(this.data == data){
            return this;
        }else {
            if(data < this.data){
                return this.left.searchNode(data);
            }else{
                return this.right.searchNode(data);
            }
        }
    }

    // �ҵ��Ըý��Ϊ�������󲿷ֵĽ��
    public Node leftMostNode(){
        if(this == null) return null;
        Node node = this;
        Node p = null;
        while( node != null){
            p = node;
            node = node.left;
        }
        return p;
    }

    // ����Ըý��Ϊ���������ĸ߶�
    public int nodeHeight(){
        if(this == null) return 0;
        if(this.left != null && this.right != null){
            return Math.max(this.left.nodeHeight(),this.right.nodeHeight())+1;
        }
        if(this.left != null && this.right == null){
            return this.left.nodeHeight() + 1;
        }
        if(this.right != null && this.left == null){
            return this.right.nodeHeight() + 1;
        }
        return 1;
    }

    // �������
    public void inOrder(){
        if(this.left != null){
            this.left.inOrder();
        }
        System.out.print(this.data+ " ");
        if(this.right != null){
            this.right.inOrder();
        }
    }

}