package leetcode;
// 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
//
//游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
//亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。
// 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
//
//假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。


// 解析：题目有两个条件很重要：一是石头总共有偶数堆，石头的总数是奇数。这两个看似增加游戏公平性的条件，
// 反而使该游戏成为了一个割韭菜游戏。我们以 piles=[2, 1, 9, 5] 讲解，假设这四堆石头从左到右的索引分别是 1，2，3，4。
//如果我们把这四堆石头按索引的奇偶分为两组，即第 1、3 堆和第 2、4 堆，
// 那么这两组石头的数量一定不同，也就是说一堆多一堆少。因为石头的总数是奇数，不能被平分。
public class 石子游戏 {
    public static void main(String[] args) {
        System.out.println(stoneGame(new int[]{5,3,4,5}));
    }

    public static boolean stoneGame(int[] piles) {
        return true;
    }
}
