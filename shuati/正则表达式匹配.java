package offer;
// 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
// 而'*'表示它前面的字符可以出现任意次（包含0次）。
// 在本题中，匹配是指字符串的所有字符匹配整个模式。
// 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配

// 有个库函数 -- 试试
//        return new String(str).matches(new String(pattern));
public class 正则表达式匹配 {
    public static void main(String[] args) {
//        String str = "aaa";
        String str = "aaa";
        char[] chs = str.toCharArray();
//        String str1 = "ab*ac*a";
        String str1 = "a*b";
        char[] pattern = str1.toCharArray();
        System.out.println(match(chs,pattern));
    }

    public static boolean match(char[] str, char[] pattern) {
        int p = 0;
        int q = 0;
        boolean b = helper(str,pattern,p,q);
        return b;
    }

    private static boolean helper(char[] str, char[] pattern, int p, int q) {
        // 结束条件:都正常匹配到最后，或者pattern最后是a*(str=aaaaaa,pattern=aaa*)
        if(p == str.length && (q == pattern.length || (q+2 == pattern.length && pattern[q+1]=='*')))
            return true;
        // 结束条件：str=ab pattern=abc*d*e*,后面的都需要*前面的出现0次  ； 或者pattern已经结束而str还没有结束
        if(p == str.length || q == pattern.length){
            if(p < str.length){
                return false;
            }else {
                while(q+1 < pattern.length && pattern[q+1] == '*'){  // 循环将多余的x*都消除 【注意】 要判断下q+1
                    q = q+2;
                }
                if(q == pattern.length) return true;
                else return false;
            }
        }

        // q的后一个是*，q对应的字符可能出现0次也可能出现多次
        if(q+1< pattern.length && pattern[q+1] == '*'){ // 【要判断下q+1，因为是跨越式使用该位置】
            if(str[p] != pattern[q] && pattern[q] != '.'){ //不等(真正的不等，且pattern中不会是.)，只可能出现0次
                return helper(str,pattern,p,q+2);
            }else {
                return helper(str,pattern,p,q+2) || helper(str,pattern,p+1,q);
            }
        }

        // 后一个字符不是*，正常比较是否匹配
        if(str[p] == pattern[q] || pattern[q] == '.'){
            return helper(str,pattern,p+1,q+1);
        }
        return false;
    }
}
