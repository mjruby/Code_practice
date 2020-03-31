package fanli.selfcode.binarysortedtree;
// 二叉树创建和遍历
// 二叉树的删除结点操作

// 同一个类 private  同一个包(default) 非同包继承 proteced 非同包不继承 public
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{7,3,10,12,5,1,9,11};
        BST_Tree bsTree = new BST_Tree();
        for (int num : arr) {
            bsTree.add(new Node(num));
        }
        System.out.println("创建的二叉搜索树，中序遍历结果为：");
        bsTree.inOrder_BST();

        System.out.println();
        System.out.println("===================================");
        bsTree.deleteNode(7);
        System.out.println("删除一个结点后");
        bsTree.inOrder_BST();

        System.out.println();
        bsTree.deleteNode(10);
        System.out.println("删除一个结点后");
        bsTree.inOrder_BST();

        System.out.println();
        bsTree.deleteNode(3);
        System.out.println("删除一个结点后");
        bsTree.inOrder_BST();

    }
}

class BST_Tree{
    Node root;

    public Node getRoot(){
        return root;
    }
    public void add(Node node){
        if(root == null){
            root = node;
        }else {
           root.addNode(node);
        }
    }

    public void inOrder_BST(){
        if(root == null) return;
        else{
            root.inOrder();
        }
    }


    public void deleteNode(int data){
        Node delNode = root.searchNode(data);
//        System.out.println("要删除的结点为："+delNode.data);
        Node parent;
        if(delNode.left == null && delNode.right == null){  // 叶子结点删除
            parent = delNode.parent;
            if(parent == null){
                root = null; // 树只有一个根结点
                return;
            }
            if(parent.left == delNode) parent.left = null;
            if(parent.right == delNode) parent.right = null;
        }else if(delNode.left != null && delNode.right != null){  // 有左右孩子的结点删除
            Node tmp = delNode.right.leftMostNode();
//            System.out.println("tmp = "+tmp.data);
            deleteNode(tmp.data);  // 不知道对不对，感觉像用了递归  -- > OK了
            delNode.data = tmp.data;
        }else{  // 只有一个孩子的结点删除
            parent = delNode.parent;
            if(parent == null){
                this.root = delNode.left == null ? delNode.right : delNode.left;
                return;
            }
            if(parent.left == delNode){
                parent.left = delNode.left == null? delNode.right : delNode.left;
            }
            if(parent.right == delNode){
                parent.right = delNode.left == null? delNode.right : delNode.left;
            }
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