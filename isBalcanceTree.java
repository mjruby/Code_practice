package fanli.selfcode.avl;
// 判断一棵树是否是平衡树

public class isBalcanceTree {
    public static void main(String[] args) {
        Node_AVL n1 = new Node_AVL(7);
        n1.left = new Node_AVL(3);
        n1.left.left = new Node_AVL(1);
        n1.left.right = new Node_AVL(5);
        n1.right = new Node_AVL(4);
        n1.left.left.left = new Node_AVL(8);

        ReturnData res = isBalanceTree(n1);
        System.out.println("判断构建的树，是否为平衡树："+res.isB);

    }

    public static ReturnData isBalanceTree(Node_AVL node){
        if(node == null){
            return new ReturnData(true,0);
        }
        ReturnData left = isBalanceTree(node.left);
        ReturnData right = isBalanceTree(node.right);
        if( !left.isB){
            return new ReturnData(false,0);
        }
        if( !right.isB){
            return new ReturnData(false,0);
        }
        if(Math.abs(left.h - right.h) > 1){
            return new ReturnData(false,0);
        }else{
            return new ReturnData(true, Math.max(left.h,right.h)+1);
        }
    }
}

class ReturnData{
    boolean isB;
    int h;

    public ReturnData(boolean isB,int h){
        this.isB = isB;
        this.h = h;
    }

}

class Node_AVL{
    int data;
    Node_AVL left;
    Node_AVL right;

    public Node_AVL(int value){
        this.data = value;
    }
}
