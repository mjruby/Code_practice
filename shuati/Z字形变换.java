package leetcode;
// 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
//
//比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
//
//L   C   I   R
//E T O E S I I G
//E   D   H   N
//之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
public class Z字形变换 {
    public static void main(String[] args) {
//        String str = "LEETCODEISHIRING";
        String str ="ABCD";
//        StringBuilder[] sb = new StringBuilder[2];
//        char ch = str.charAt(0);
//        sb[0].append(ch);
//        System.out.println(sb[0]);
        System.out.println(convert(str,4));

    }

    public static String convert(String s, int numRows) {
        if("".equals(s)) return "";  // 注意下这里的判断
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        int len = s.length();
        int index = 0;
        int sb_index = 0;
        String res = "";
        while(true) {
            for (sb_index = 0; sb_index < numRows && index<len; sb_index++) {
                sb[sb_index].append(s.charAt(index++));
                if (index == len) break;
            }
            for (sb_index -= 2; sb_index > 0 && index<len; sb_index--) {
                sb[sb_index].append(s.charAt(index++));
                if (index == len) break;
            }
            if(index == len) break;
        }

        for(int i = 0; i < numRows; i++) {
            res +=sb[i].toString();
        }
        return res;
    }
}
