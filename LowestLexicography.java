package primary.courseseven.self;

import java.util.Arrays;
import java.util.Comparator;

// 给定一个字符串类型的数组strs，找到一种拼接方式，
// 使得把所有字符串拼起来之后形成的字符串具有最低的字典序。
public class LowestLexicography {

    public static class LowComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            // compareTo 用于字符串大小的比较
            return (o1 + o2).compareTo(o2 + o1);
        }
    }

    public static String lowestLexicography(String[] strs){
        if(strs == null) return "";
        Arrays.sort(strs, new LowComparator());
        String res = "";
        for (String str : strs) {
            res += str;
        }
        return res;
    }

    public static void main(String[] args) {
//        String str1 = "ab";
//        String str2 = "ad";
//        System.out.println(str1.compareTo(str2)); // -2

        String[] strs = new String[]{"ac","b"};  // acb
        System.out.println("最小字典序："+ lowestLexicography(strs));

        String[] strs1 = new String[]{"cd","ca","bf"};
        System.out.println("最小字典序："+ lowestLexicography(strs1));  // bfcacd
    }
}
