package offer;
// 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
// 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
// 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。

//（1）+，-只能放在首位或者E,e的后面
//（2）E或e，以及小数点只能出现一次，并且：在有E或者e的情况下，小数点不能在E，e后面出现
//（3）不能有除了数字，E，e，小数点，+，-之外的其他字符出现
//（4）e或E后面必须出现数字，如果后面是+或-，continue，继续判单有没有数字，直到找到为止。
//（5）不能是空符号串
public class 表示数值的字符串 {

    public static void main(String[] args) {
        String s1 = "12e";
        char[] ch1 = s1.toCharArray();
        System.out.println(isNumeric(ch1));
    }

    public static boolean isNumeric(char[] str) {
        int len = str.length;
        if (len == 0) return false;
        int cnt1 = 0, cnt2 = 0, cnt3 = 0;
        int pos1 = 0, pos2 = 0, pos3 = 0;

        for (int i = 0; i < len; i++) {
            if (str[i] != 'E' && str[i] != 'e' && str[i] != '+' && str[i] != '-' && str[i] != '.' && !(str[i] >= '0' && str[i] <= '9'))
                return false;
            else {
                if(str[i] == 'E'|| str[i]=='e') {cnt1++; pos1 = i;}
                if(str[i] == '+'|| str[i]=='-') {cnt2++; pos2 = i;}
                if(str[i] == '.') {cnt3++; pos3 = i;}
            }
        }

        if(cnt1>1||cnt2>2||cnt3>1) return false;
        // e和+，-的关系
        if(cnt1==0 && (cnt2 > 0 && pos2 != 0)) return false;  // 没有e
        if(cnt1!=0){  // 有e
            if((len-1) == pos1) return false;
            if(cnt2>0 && (pos2 != 0 && pos2 != pos1+1)) return false;
        }
        // 小数点必须在e之前
        if(cnt3>0 && cnt1 > 0 && pos3 > pos1) return false;
        return true;
    }
}
