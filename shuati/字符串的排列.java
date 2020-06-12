package offer;
// 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
// 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
public class 字符串的排列 {
    public static void main(String[] args) {
        String str = "acb";
        ArrayList<String> rs = Permutation(str);
        System.out.println(rs);

    }
//
//    public static ArrayList<String> Permutation(String str) {
//        char[] chs = str.toCharArray();
//        Arrays.sort(chs);
//        int len = chs.length;
//        ArrayList<Character> ls = new ArrayList<>();
//        for (int i = 0; i < len; i++) {
//            ls.add(chs[i]);
//        }
//        ArrayList<String> ans = new ArrayList<>();
//        ArrayList<Character> track = new ArrayList<>();
//        backTrack(ls,track,ans,len);
//        return ans;
//    }
//
//    public static void backTrack(List<Character> ls, ArrayList<Character> track, ArrayList<String> ans, int len){//选择，路径，结果,len
//        if( track.size() == len ){
//            String s = track.toString();
//            ans.add(s);
//            return;
//        }
//        for (int i = 0; i < ls.size(); i++) {
//            // 做选择
//            track.add(ls.get(i));
//            ls.remove(i);
//            backTrack(ls,track,ans,len);
//            // 撤销选择
//            Character ch = track.remove(track.size() - 1);
//            ls.add(0,ch);
//        }
//    }

//// 别人的代码【字典序】
//// 注意，我以为是全排列问题，好像不是，输入acb,答案  [acb, acb, bac, bca, cab, cba]
//    public static ArrayList<String> Permutation(String str) {
//        ArrayList<String> res = new ArrayList<String>();
//        if(str.length() == 0) return res;
//        char [] array = str.toCharArray();
//        Arrays.sort(array);
//        String s = new String(array);
//        res.add(s);
//        while(true){
//            s = nextString(s);
//            if(!s.equals("finish")){
//                res.add(s);
//            }
//            else{
//                break;
//            }
//        }
//        return res;
//    }
//
//    public static String nextString(String str){
//        char [] array = str.toCharArray();
//        int length = str.length();
//        int i = length-2;
//        for(; i>=0 && array[i] >= array[i+1]; i--);
//        if(i == -1) return "finish";
//        int j = length-1;
//        for(; j>=0 && array[j] <= array[i]; j--);
//        //swap i,j
//        char tmp = array[i];
//        array[i] = array[j];
//        array[j] = tmp;
//        //swap i,j
//        for(int a=i+1, b=length-1; a<b;a++,b--){
//            tmp = array[a];
//            array[a] = array[b];
//            array[b] = tmp;
//        }
//        return new String(array);
//    }


    // 看了字典序，自己写
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> rs = new ArrayList<>();
        if(str.length() == 0 || str == null) return rs;
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        String s = String.valueOf(chs);
        rs.add(s);
        String newstr = next(s);
        while( newstr!=null){
            rs.add(newstr);
            newstr  = next(newstr);
        }
        return rs;
    }

    private static String next(String newstr) {
        char[] chs = newstr.toCharArray();
        int len = chs.length;
        int i;
        for (i = len-2; i >= 0; i--) {  // 从右向左找出第一个正序
            if(chs[i] < chs[i+1])  // < 可避免重复字符的影响
                break;
        }
        if(i==-1) return null;
        // 针对i位置上的数，从右向左找出第一个比它大的数
        int j;
        for (j = len-1;  j>i; j--) {
            if(chs[j] > chs[i]) break;
        }
        swap(chs,i,j);
        // 从i+1到len-1倒序
        for (int m = i+1,n = len-1;m<n; m++,n--) {
            swap(chs,m,n);
        }
        return new String(chs);
    }

    public static void swap(char[] nums,int i,int j){
        char tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
