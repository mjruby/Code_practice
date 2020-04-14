package leetcode;
// 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
//有效字符串需满足：
//
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。
//注意空字符串可被认为是有效字符串。

import java.util.Stack;

public class 有效的括号 {
    public static void main(String[] args) {
        String str = "()";
        String str1 = "()[]{}";
        String str2 = "(]";
        System.out.println(isValid(str));
        System.out.println(isValid(str1));
        System.out.println(isValid(str2));
    }

    public static boolean isValid(String s) {
//        if(s == null) return true;  // 不需要，后面当为空，会判定为true
        Stack<Character> st = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch =='['){
                st.add(ch);
            }else {
                if(st.isEmpty()) return false;
                char tmp = st.pop();
                if(ch == ')' && tmp !='(') return false;
                if(ch == ']' && tmp !='[') return false;
                if(ch == '}' && tmp !='{') return false;
            }
        }
        if(st.isEmpty()) return true;
        else return false;
    }
}
