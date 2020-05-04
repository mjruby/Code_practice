package leetcode;

import javax.swing.text.html.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
public class N_皇后 {
    public static void main(String[] args) {
        int n =  4;
        List<List<String>> rs = solveNQueens(n);
        System.out.println(rs);

        List<String> ll = new ArrayList<>();
//        char[] ch  = new char[5];
//        Arrays.fill(ch,'.');
//        System.out.println(Arrays.toString(ch));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ls = new ArrayList();
        // board
        char[][] board = new char[n][n];
        helper(0,board,ls);
        return ls;
    }

    private static void helper(int r, char[][] board, List<List<String>> ls) {
        if(r == board.length){   // 这个输出的处理很重要
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                tmp.add(new String(board[i]));
            }
            ls.add(tmp);
        }else {
            Arrays.fill(board[r], '.');
            for (int j = 0; j < board.length; j++) {
                if(!isValid(board,r,j)) continue;
                board[r][j] = 'Q';
                helper(r+1,board,ls);
                board[r][j] = '.';
            }
        }
    }

    private static boolean isValid(char[][] board, int row, int j) {
        //  正上方
        int len = board.length;
        for (int i = 0; i < row; i++) {
            if(board[i][j] == 'Q') return false;
        }
        // 左上方
        int i = 0,k =0;
        for (i = row - 1 , k = j -1; i >= 0 && k >= 0; i--,k--) {
            if(board[i][k] == 'Q') return false;
        }
        // 右上方
        for (i = row - 1 , k = j+1; i >= 0 && k <= len-1; i--,k++) {
            if(board[i][k] == 'Q') return false;
        }
        return true;
    }
}
