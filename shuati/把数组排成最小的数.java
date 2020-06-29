package offer;
// 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
// 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。

import com.sun.jdi.connect.Connector;

import java.util.*;

public class 把数组排成最小的数 {
    public static void main(String[] args) {
        int[] nums = {3, 32, 321};
        String s = PrintMinNumber(nums);
        System.out.println(s);

//        char[] arr = {'a','b','c'};
//        List<String> rs = new ArrayList<>();
//        perm1(arr,rs);
//        perm2(arr,0,arr.length,rs);
//        System.out.println(rs);

    }

    static class CompareStr implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            return Integer.parseInt((o1+o2))-Integer.parseInt((o2+o1));
        }
    }

    public static String PrintMinNumber(int [] numbers) {
        if(numbers.length == 0) return "";
        ArrayList<String> ls = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            ls.add(String.valueOf(numbers[i]));
        }

        // 下面的排序也是可以的
//        Collections.sort(ls,new CompareStr());
//        ls.sort(new CompareStr());

        // PriorityQueue源码，当第一个元素出列之后，对剩下的元素进行再排序，挑选出最小的元素排在数组第一个位置。
        PriorityQueue<String> pq = new PriorityQueue<>(new CompareStr());
        for (int i = 0; i < numbers.length; i++) {
            pq.add(String.valueOf(numbers[i]));
        }

        StringBuilder sb = new StringBuilder();
        int len = pq.size();
        for (int i = 0; i < len; i++) {
            String r = pq.remove();
            sb.append(r);
        }
        return sb.toString();
    }

    // 全排列方法尝试一
    public static void perm1(char[] chs,List<String> rs){
        List<Character> lists = new ArrayList<>();
        for (int i = 0; i < chs.length; i++) {
            lists.add(chs[i]);
        }
        // 选择列表，路径,结果集,总的长度
        StringBuilder tracks = new StringBuilder();
        helper(lists,tracks,rs,lists.size());
    }

    private static void helper(List<Character> lists, StringBuilder tracks, List<String> rs,int len) {
        if(tracks.length() == len){
            rs.add(tracks.toString());
            return;
        }
        for (int i = 0; i < lists.size(); i++) {
            Character ch = lists.get(i);
            tracks.append(ch);
            lists.remove(i);
            helper(lists,tracks,rs,len);
            lists.add(i,ch);  // 删除在哪个位置，补齐就在哪个位置
            tracks.deleteCharAt(tracks.length()-1);
        }
    }


    // 全排类方法尝试二  =======  成功！
    public static void perm2(char[] chs,int p,int q,List<String> rs){  // 左闭右开
        // 结束条件
        if(p+1 == q){
            rs.add(new String(chs));
        }
        for (int i = p; i < q; i++) {
            swap(chs,p,i);
            perm2(chs,p+1,q,rs);
            swap(chs,i,p);
        }
    }

    public static void swap(char[] chs,int p ,int q){
        char tmp = chs[p];
        chs[p] = chs[q];
        chs[q] = tmp;
    }
}
