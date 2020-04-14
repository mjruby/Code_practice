package leetcode;
// 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

//示例：
//
//输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    public static void main(String[] args) {
        int n = 1;
        List<String> ls = generateParenthesis(n);
        System.out.println(ls);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper("",n,list,0,0);
        return list;
    }

    public static void helper(String curStr,int n, List<String> ls,int left, int right){
        if(right == n){
            ls.add(curStr);
            return;
        }
        if(left < n){
            helper(curStr+"(",n,ls,left+1,right);
        }
        if(right < left){
            helper(curStr+")",n,ls,left,right+1);
        }
    }
}
