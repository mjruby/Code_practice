package leetcode;
// 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
//
//示例 1:
//输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
//示例 2:
//输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"

import java.util.Stack;

public class 最长有效括号 {
    public static void main(String[] args) {
        String str = "())";
        String str1 = "(()))())("; // 4
        System.out.println(longestValidParentheses(str));
        System.out.println(longestValidParentheses(str1));
    }

    public static int longestValidParentheses(String s) {
        if (s == null || "".equals(s)) return 0;
        Stack<Integer> st = new Stack<>();
        int max = 0;
        int len = s.length();
        st.push(0);
        int leftmost = -1;
        for (int i = 1; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '(') st.push(i);
            else {
                if(!st.isEmpty()){
                    int tmp = st.pop();
                    if( s.charAt(tmp) == '('){
                        if (st.isEmpty()) {
                            max = Math.max(max, i - leftmost);
                        } else {
                            max = Math.max(max, i - st.peek());
                        }
                    }else {
                        leftmost = i;
                    }
                }else {
                    leftmost = i;
                }
            }
        }
        return max;
    }
}
