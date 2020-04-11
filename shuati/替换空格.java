package offer;
//请实现一个函数，将一个字符串中的每个空格替换成“%20”。
//        例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
public class 替换空格 {
    public static void main(String[] args) {
        StringBuffer strbuf= new StringBuffer();
//        strbuf.append("We%20Are%20Happy");
        strbuf.append("hello world");
        System.out.println(replaceSpace(strbuf));

    }

    public static String replaceSpace(StringBuffer str) {
//        if(str.length() == 0) return "%20";
        String s = str.toString();
        String s1 = s.replaceAll(" ", "%20");
        return s1;
    }
//
//    public static String replaceSpace(StringBuffer str) {
//        return str.toString().replace(" ", "%20");
//    }
}
