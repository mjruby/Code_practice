package offer;
// 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
// 输入一个字符串,包括数字字母符号,可以为空
public class 把字符串转换成整数 {
    public static void main(String[] args) {
        String str1 = "+2144447483647";
        System.out.println(StrToInt(str1));
        String str2 = "-1900";
        System.out.println(StrToInt(str2));
    }

    public static int StrToInt(String str) {
        if(str == null || str.length() == 0 ) return 0;
        char[] chs = str.toCharArray();
        int len = chs.length;
        int res = 0; int idx = 1;
        for (int i = len-1; i > 0; i--) {
            if(chs[i] >= '0' && chs[i] <= '9'){
                if((Integer.MAX_VALUE - res) < (chs[i]-'0') * idx) return 0;  // 判断是否越界
                res += (chs[i]-'0') * idx;
                idx *= 10;
            }else {
                return 0;
            }
        }
        if(chs[0] == '-') return res*(-1);
        if(chs[0] == '+') return res;
        return res+= (chs[0]-'0') * idx;
    }
}
