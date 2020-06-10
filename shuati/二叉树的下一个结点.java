package offer;
// 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
// 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
public class 二叉树的下一个结点 {
    public static void main(String[] args) {
        TreeLinkNode node1  = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3  = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        /*node1.next= null;node1.left = node2;
        node2.next = node1;node2.left = node3;node2.right = node4;
        node3.next=node2;node3.left=node5;node3.right=node6;
        node4.next = node2;
        node5.next = node3;
        node6.next = node3;*/
        node5.left = node4;node5.next = null;
        node4.left = node3;node4.next = node5;
        node3.left = node2;node3.next= node4;
        node2.next = node3;

        System.out.println("========================");
        System.out.println(GetNext(node5));
//        System.out.println("========================");
//        System.out.println(GetNext(node2).val);
//        System.out.println("========================");
//        System.out.println(GetNext(node6).val);

    }

    public static TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null) return null;
        if(pNode.right != null) return leftNode(pNode.right);
        else
            return upToFindNext(pNode);

    }

    // 右子树的头结点
    public static TreeLinkNode leftNode(TreeLinkNode pnode){
        TreeLinkNode tmp = pnode;
        while(tmp.left != null){
            tmp = tmp.left;
        }
        return tmp;
    }

    // 叶子结点的next , 头结点的next是null
    public static TreeLinkNode upToFindNext(TreeLinkNode leaf){
        TreeLinkNode pre = leaf.next;
        TreeLinkNode cur = leaf;
        while(pre != null && pre.left != cur){
            cur = pre;
            pre = pre.next;
        }
        return pre;
    }


}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}