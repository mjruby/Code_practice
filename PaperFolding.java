package primary.soursefour.selfcode;
//折纸问题 【题目】 请把一段纸条竖着放在桌子上，
//        然后从纸条的下边向上方对折1次，压出折痕后展开。此时折痕是凹下去的，
//        即折痕突起的方向指向纸条的背面。
//        如果从纸条的下边向上方连续对折 2 次，
//        压出折痕后展开，此时有三条折痕，从上到下依次是下折痕、下折痕和上折痕。
//        给定一个输入参数N，代表纸条都从下边向上方连续对折N次，
//        请从上到下打印所有折痕的方向。
//        例如：N=1时，打印： down N=2时，打印：down down up

// 实质: 满二叉树的【中序遍历】.根节点为down,其他节点递归定义:左孩子为down && 右孩子为up
// 网上解法: https://blog.csdn.net/caoxiaohong1005/article/details/78384281

public class PaperFolding {
    public static void paperFolding(int n){  // n -- 折纸的次数
        inOderPaperFold(1,n,true);
    }

    public static void inOderPaperFold(int cur, int n, Boolean isDown){
        // cur -- 当前为第 i 次折； n -- 总的折叠次数设置  isDown -- 判断是否为向下
        if(cur > n){
            return;

        }
        inOderPaperFold(cur + 1 ,n,true);
        System.out.println(isDown? "down" : "up");
        inOderPaperFold(cur + 1,n,false);
    }

    public static void main(String[] args) {
        System.out.println("折叠三次的结果为：");
        paperFolding(3);

        System.out.println("折叠两次的结果为：");
        paperFolding(2);
    }
}
