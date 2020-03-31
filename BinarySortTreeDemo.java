package fanli.selfcode.binarysortedtree;
// �����������ͱ���
// ��������ɾ��������

// ͬһ���� private  ͬһ����(default) ��ͬ���̳� proteced ��ͬ�����̳� public
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{7,3,10,12,5,1,9,11};
        BST_Tree bsTree = new BST_Tree();
        for (int num : arr) {
            bsTree.add(new Node(num));
        }
        System.out.println("�����Ķ���������������������Ϊ��");
        bsTree.inOrder_BST();

        System.out.println();
        System.out.println("===================================");
        bsTree.deleteNode(7);
        System.out.println("ɾ��һ������");
        bsTree.inOrder_BST();

        System.out.println();
        bsTree.deleteNode(10);
        System.out.println("ɾ��һ������");
        bsTree.inOrder_BST();

        System.out.println();
        bsTree.deleteNode(3);
        System.out.println("ɾ��һ������");
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
//        System.out.println("Ҫɾ���Ľ��Ϊ��"+delNode.data);
        Node parent;
        if(delNode.left == null && delNode.right == null){  // Ҷ�ӽ��ɾ��
            parent = delNode.parent;
            if(parent == null){
                root = null; // ��ֻ��һ�������
                return;
            }
            if(parent.left == delNode) parent.left = null;
            if(parent.right == delNode) parent.right = null;
        }else if(delNode.left != null && delNode.right != null){  // �����Һ��ӵĽ��ɾ��
            Node tmp = delNode.right.leftMostNode();
//            System.out.println("tmp = "+tmp.data);
            deleteNode(tmp.data);  // ��֪���Բ��ԣ��о������˵ݹ�  -- > OK��
            delNode.data = tmp.data;
        }else{  // ֻ��һ�����ӵĽ��ɾ��
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