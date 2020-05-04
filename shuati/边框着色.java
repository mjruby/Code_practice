package leetcode;
// 输入：grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1, color = 3
//输出：[[1, 3, 3], [2, 3, 3]]

// [[1,2,1],[1,2,2],[2,2,1]]
//1
//1
//2

// [[1,2,1,2,1,2],[2,2,2,2,1,2],[1,2,2,2,1,2]]
//1
//3
//1

// [[2,1,3,2,1,1,2],[1,2,3,1,2,1,2],[1,2,1,2,2,2,2],[2,1,2,2,2,2,2],[2,3,3,3,2,1,2]]
//4
//4
//3

// 题目意思： 就是连通分量中接触到非连通那部分的正方形染色，还有一点在连通分量中，处于边框边缘区域的地方染色，
// 说白了就是把一个连通分量的边界染色，
public class 边框着色 {
    public static void main(String[] args) {
//        int[][] grid = new int[][]{{1,2,2},{2,3,2}};
//        int[][] grid = new int[][]{{1,2,1},{1,2,2},{2,2,1}};
        int[][] grid = new int[][]{{2,1,3,2,1,1,2},{1,2,3,1,2,1,2},{1,2,1,2,2,2,2},
                {2,1,2,2,2,2,2},{2,3,3,3,2,1,2}};
        int r0 = 4, c0 = 4, color = 3;
        test.printInts(grid);
        int[][] res = colorBorder(grid, r0, c0, color);
        test.printInts(res);
    }

    public static int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        if(grid == null || grid.length == 0 || r0>grid.length || c0>grid[0].length)
            return new int[][]{};
        int orignColor = grid[r0][c0];
        if(orignColor == color) return grid;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        floodFill(grid,r0,c0,orignColor,color,visited);
        return grid;
    }

    public static void floodFill(int[][] img,int sr,int sc,int orignColor,int newColor,boolean[][] visited){
        if(sr < 0 || sc < 0 || sr >= img.length || sc >= img[0].length || visited[sr][sc]) return;  // 超出边界或已被访问
        if(img[sr][sc] != orignColor) return; // 遇到其他区域

        // 着色有一定限制
        if(sr == 0 || sc == 0 || sr == img.length -1 || sc == img[0].length -1){  // 边界
            img[sr][sc] = newColor;
        } else if( (img[sr-1][sc] != orignColor && !visited[sr-1][sc])  // 判断该点四周是否被包围
                || (img[sr+1][sc] != orignColor && !visited[sr+1][sc])
                || (img[sr][sc+1] != orignColor && !visited[sr][sc+1])
                || (img[sr][sc-1] != orignColor && !visited[sr][sc-1])){
            img[sr][sc] = newColor;
        }
        visited[sr][sc] = true;
        floodFill(img,sr+1,sc,orignColor,newColor,visited);
        floodFill(img,sr-1,sc,orignColor,newColor,visited);
        floodFill(img,sr,sc+1,orignColor,newColor,visited);
        floodFill(img,sr,sc-1,orignColor,newColor,visited);
    }
}
