package offer;
// 请实现一个函数用来找出字符流中第一个只出现一次的字符。
// 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
// 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
// 如果当前字符流没有存在出现一次的字符，返回#字符。


import java.util.LinkedList;
import java.util.Queue;

public class 字符流中第一个不重复的字符 {
    static Queue<Character> q = new LinkedList<>();
    public static void main(String[] args) {
        Insert('h');
        System.out.println(FirstAppearingOnce());
        Insert('e');
        System.out.println(FirstAppearingOnce());
        Insert('l');
        System.out.println(FirstAppearingOnce());
        Insert('l');
        System.out.println(FirstAppearingOnce());
        Insert('o');
        System.out.println(FirstAppearingOnce());
        Insert('w');
        System.out.println(FirstAppearingOnce());
        Insert('o');
        System.out.println(FirstAppearingOnce());
        Insert('r');
        System.out.println(FirstAppearingOnce());
        Insert('d');
        System.out.println(FirstAppearingOnce());

    }
    // 自己的，挺清楚的：还好好利用了q.remove删除队列中的某一个对象
    //Insert one char from stringstream
    public static void Insert1(char ch) {
        if(q.contains(ch)){ // 有过一次，从队列中移除
            q.remove(ch);
        }else {
            q.add(ch);
        }
    }
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce1() {
        if(!q.isEmpty()) return q.peek();
        return '#';
    }

    // other
    static int[] visited = new int[256];
    static String str = ""; // 记录插入的字符
    public static void Insert(char ch) {
            str += ch;
            visited[ch] += 1;
    }
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce() {
        char[] chs = str.toCharArray();
        for (char ch : chs) {
            if(visited[ch] == 1){
                return ch;
            }
        }
        return '#';
    }
}


