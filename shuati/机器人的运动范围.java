package offer;

// 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
// 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37）
// ，因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？

// 超过10，是拆开加
public class 机器人的运动范围 {
    public static void main(String[] args) {
        System.out.println(movingCount(15, 20, 20));  // 正确的是359  15,20,20
        System.out.println(mySum(23,13));
    }

    static int count = 0;
    public static int movingCount(int threshold, int rows, int cols) {
        if (threshold >= rows + cols - 2) return rows * cols;
        // 创建一个数组，表示某位已经被计数过
        boolean[][] visited = new boolean[rows][cols];
        helper(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    private static void helper(int threshold, int rows, int cols, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= rows) return;
        if (j < 0 || j >= cols) return;
        if (visited[i][j]) return;
        if (mySum(i,j)> threshold) return;
        if (mySum(i,j) <= threshold) {
            count++;
            visited[i][j] = true;
            helper(threshold, rows, cols, i - 1, j, visited); // 上
            helper(threshold, rows, cols, i + 1, j, visited); // 下
            helper(threshold, rows, cols, i, j - 1, visited); // 左
            helper(threshold, rows, cols, i, j + 1, visited); // 右
        }
    }

    public static int mySum(int i,int j){
        int sum = 0;
        while(i != 0){
            sum += i % 10;
            i = i/10;
        }
        while(j != 0){
            sum += j % 10;
            j = j/10;
        }
        return sum;
    }
}
