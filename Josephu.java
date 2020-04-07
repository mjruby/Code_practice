package fanli.selfcode.josephu;
//        Josephu(约瑟夫、约瑟夫环)  问题
//        问题为：设编号为1，2，… n的n个人围坐一圈，约定编号为k（1<=k<=n）的人从1开始报数，
//        数到m 的那个人出列，它的下一位又从1开始报数，数到m的那个人又出列，
//        依次类推，直到所有人出列为止，由此产生一个出队编号的序列。

public class Josephu {
    Node firstNode = new Node(0);
    public static void main(String[] args) {
        Josephu js = new Josephu();
        js.generateJosephu(7);
        js.printRing();
        js.jsp(0,3);
    }

    // 根据num,生成约瑟夫环
    public void generateJosephu(int num){
        Node curNode = this.firstNode;
        for (int i = 1; i < num; i++) {
            curNode.next = new Node(i);
            curNode = curNode.next;
        }
        curNode.next = firstNode;
    }

    // 打印环
    public void printRing(){
        Node curNode = firstNode.next;
        System.out.print(firstNode.data+"  ");
        while(curNode != firstNode){
            System.out.print(curNode.data+"  ");
            curNode = curNode.next;
        }
        System.out.println();
    }

    // 从startIndex开始，数到count则排除一个
    public void jsp(int startIndex,int count){
        Node helper = firstNode;
        while(helper.next != firstNode){
            helper =  helper.next;
        }
        Node p = firstNode;
        // 定位好开始的位置
        while (startIndex>0){
            firstNode = firstNode.next;
            helper = helper.next;
            startIndex--;
        }
        // 开始定数移除
        while (firstNode.next != firstNode){
            int curCount = count;
            while (curCount>0){
                if(curCount > 1){
                    firstNode = firstNode.next;
                    helper = helper.next;
                }else {
                    System.out.print(firstNode.data+"  ");
                    firstNode = firstNode.next;
                    helper.next = firstNode;
                }
                curCount--;
            }
        }
        System.out.print(firstNode.data);
    }
}


class Node{
    int data;
    Node next;
    public Node(int value){
        this.data = value;
    }
}