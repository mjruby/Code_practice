package offer;

import java.awt.*;
import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.Arrays;

public class 矩阵中的路径 {
    public static void main(String[] args) {
        String str1 = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS";
        String str2 = "SLHECCEIDEJFGGFIE";
        char[] matrix = str1.toCharArray();
        char[] str = str2.toCharArray();
        System.out.println(hasPath(matrix,5,8,str)); // false

    }
    static boolean q = false;
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if(matrix==null || matrix.length < str.length) return false;
        // 重构matrix,并且新建一个visited的矩阵
        char[][] chs = new char[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                chs[i][j] = matrix[i*cols+j];
            }
        }
        ArrayList<Character> tracks=new ArrayList<Character>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(chs[i][j] == str[0]){  // 起始点比较，helper是从起始点开始的上下左右
                    // chs-整个矩阵，visited,i，j-以i，j开头，tracks-走过的路径，str-想要的路径
                    tracks.add(str[0]);visited[i][j] = true;
                    helper(chs, cols, rows, visited, i, j, tracks, str);
                    tracks.remove(tracks.size()-1); //【可以出现两个开头的是符合要求的，不行的需要从tracks中去除】
                    visited[i][j] = false;
                    if(q) return true;
                }
            }
        }
        return false;
    }

    private static void helper(char[][] chs,int cols,int rows, boolean[][] visited, int i, int j, ArrayList<Character> tracks, char[] str) {
        // 结束条件
        if(q){
            return;
        }
        if(tracks.size() == str.length){
            q = true;return;
        }
        if(i==rows && j == cols){
            return;
        }
        // 上下左右四个方向的坐标
        ArrayList<Point> ls=new ArrayList<>();
        ls.add(new Point(i,j-1)); // 左
        ls.add(new Point(i,j+1)); // 右
        ls.add(new Point(i-1,j)); // 上
        ls.add(new Point(i+1,j)); // 下

        int len = ls.size();
        for (int k = 0; k < len; k++) {
            Point p = ls.get(k);
//            Point p = ls.remove(0);
            if(p.x < 0 || p.x >= rows) continue;
            if(p.y < 0 || p.y >= cols) continue;
            if(visited[p.x][p.y]) continue;
            if(chs[p.x][p.y] != str[tracks.size()])
                continue;
            tracks.add(chs[p.x][p.y]);
            visited[p.x][p.y] = true;
            helper(chs, cols, rows, visited, p.x, p.y, tracks, str);
            tracks.remove(tracks.size()-1);
            visited[p.x][p.y] = false;
        }
    }
}
