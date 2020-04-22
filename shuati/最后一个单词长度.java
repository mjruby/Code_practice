package leetcode;
import jdk.jfr.StackTrace;

// 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，
// 返回其最后一个单词的长度。如果字符串从左向右滚动显示，
// 那么最后一个单词就是最后出现的单词。
//
//如果不存在最后一个单词，请返回 0 。
//
//说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
public class 最后一个单词长度 {
    public static void main(String[] args) {
        String str = "c d fff";
        System.out.println(lengthOfLastWord(str));
    }

    public static int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        int count = 0;
        int cur = count;
        boolean flag = false;
        String str = s.trim();
        if(str.length() == 0) return 0;

        for (int i = 0; i < len; i++) {
            if(s.charAt(i) == ' ' && !flag){
                count = cur;
                cur = 0;
                flag = true;
            }else if(s.charAt(i) != ' '){
                cur++;
                flag = false;
            }
        }
        count = cur== 0 ? count:cur;
        return count;
    }
}
