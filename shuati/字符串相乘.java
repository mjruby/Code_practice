package leetcode;
// 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
//示例 1:
//
//输入: num1 = "2", num2 = "3"
//输出: "6"
//示例 2:
//
//输入: num1 = "123", num2 = "456"
//输出: "56088"
public class 字符串相乘 {
    public static void main(String[] args) {
        String num1 = "1236";
        String num2 = "4561";
        System.out.println(multiply(num1,num2));
    }

    public static String multiply(String num1, String num2) {
        if(num1.length() == 1 && (num1.charAt(0) -'0')== 0  ||  num2.length() == 1 && (num2.charAt(0) -'0')== 0)
            return "0";
        int len1 = num1.length();
        int len2  = num2.length();

        int[] res = new int[len1 + len2];
        for (int i = len1-1; i >= 0; i--) {
            for (int j = len2-1; j >= 0; j--) {
                int tmp = (num1.charAt(i)-'0') * (num2.charAt(j) - '0');
                int idx = (len1 - 1 - i) + (len2 - 1 - j);
                int tmp_idx = res[idx];
                res[idx] = (tmp_idx + tmp) % 10;
                res[idx + 1] = (tmp_idx + tmp) / 10 + res[idx + 1];  // 一定记住加上本来的
            }
        }

        // 除去前面是0
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = res.length -1; i >= 0 ; i--) {
            if(res[i] == 0) count++;
            else break;
        }
        for (int i = res.length -1; i >= 0; i--) {
            sb.append(res[i]);
        }
        return sb.substring(count);
    }
}
