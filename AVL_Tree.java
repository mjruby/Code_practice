package fanli.selfcode.avl;
// 构建 AVL树（平衡二叉搜索树）

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
        int[] arr = new int[]{10,11,7,6,8,9};   // 下面这两个例子，需要双旋转才能使树平衡
//        int[] arr = new int[]{2,1,6,5,7,3};
        AVLTree avlTree = new AVLTree();
        for (int num : arr) {
            avlTree.add(new Node(num));
        }
        System.out.println("平衡树的左子树高："+ avlTree.getRoot().left.nodeHeight());
        System.out.println("平衡树的右子树高："+ avlTree.getRoot().right.nodeHeight());
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

    // 调整树，参数是根结点，返回新的根结点
    public Node adjust_AVLTree(Node root) {
        if(root.left != null && root.right != null){
            if ((root.left.nodeHeight() - root.right.nodeHeight()) > 1) { // 右旋转
                if(root.left.right.nodeHeight() > root.left.left.nodeHeight()){// 先左子树左旋一个
                    Node subLeftRotate = root.left;
                    Node tmp = subLeftRotate.right;
                    subLeftRotate.right = tmp.left;
                    tmp.left = subLeftRotate;
                    root.left = tmp;
                }
                Node tmp = root.left;
                root.left = tmp.right;
                tmp.right = root;
                return tmp; // 新的根节点
            } else if ((root.right.nodeHeight() - root.left.nodeHeight()) > 1) { // 左旋转
                if(root.right.left.nodeHeight() > root.right.right.nodeHeight()){ // 部分右旋一下
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
                if(root.right.nodeHeight() > 1){  // 左旋转
                    Node tmp = root.right;
                    root.right = tmp.left;
                    tmp.left = root;
                    return tmp;
                }
            }else if(root.right == null && root.left != null){
                if(root.left.nodeHeight() > 1){ // 右旋转
                    Node tmp = root.left;
                    root.left = tmp.right;
                    tmp.right = root;
                    return tmp; // 新的根节点
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

    // 添加结点 递归
    public void addNode(Node node){
        if(node == null) return;
        if(node.data < this.data){
            if(this.left == null){
                this.left = node;
                node.parent = this;
            }else {
                this.left.addNode(node); // 以left为根结点去添加新的结点
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

    // 找到要删除的结点
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

    // 找到以该结点为根的最左部分的结点
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

    // 求出以该结点为根结点的树的高度
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

    // 中序遍历
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