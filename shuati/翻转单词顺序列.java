package offer;

import java.util.Arrays;

public class 翻转单词顺序列{
    public static void main(String[] args) {
        String str = "     ";
        String rs = ReverseSentence(str);
        System.out.println(rs);
    }

    public static String ReverseSentence(String str) {
//        if(str.length() == 0 || "".equals(str) || " ".equals(str)) return str; // 错误代码
        String[] ss = str.split(" ");
        int len = ss.length;
        if(len < 1){   // 【关键点 ==== 空格数可能为1~7，所以按空格分隔后，如果长度为0，则直接返回原字符串】
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = len-1; i >= 0; i--) {
            if(i==0){
                sb.append(ss[i]);
                break;
            }
            sb.append(ss[i]+" ");
        }
        return sb.toString();
    }
}
