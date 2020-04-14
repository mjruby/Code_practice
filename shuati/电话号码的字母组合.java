package leetcode;
// 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

// 输入："23"
// 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

// 递归 ***********
import java.util.*;

public class 电话号码的字母组合 {
    public static void main(String[] args) {
        String str = "234";
        List<String> list = letterCombinations(str);
        System.out.println(list);
    }

    public static List<String> letterCombinations(String digits) {
        HashMap<Character,Character[]> map = new HashMap<>();
        map.put('2',new Character[]{'a','b','c'});
        map.put('3',new Character[]{'d','e','f'});
        map.put('4',new Character[]{'g','h','i'});
        map.put('5',new Character[]{'j','k','l'});
        map.put('6',new Character[]{'m','n','o'});
        map.put('7',new Character[]{'p','q','r','s'});
        map.put('8',new Character[]{'t','u','v'});
        map.put('9',new Character[]{'w','x','y','z'});

        List<String> ls = new ArrayList<>();
        if(digits==null || digits.length()==0) return ls;
        helper("",0,digits,map,ls);
//        bfs(digits,ls,map);
         return ls;
    }

    // 深度优先
    public static void helper(String curStr, int index, String digits,HashMap<Character,Character[]> map,List<String> list){
        if(index == digits.length()){
            list.add(curStr);
            return;
        }
        char ch = digits.charAt(index);
        if(map.containsKey(ch)){
            for (Character c : map.get(ch)) {
                helper(curStr+c,index+1,digits,map,list);
            }
        }
    }

    // 广度优先
    public static void bfs(String digits,List<String> list,HashMap<Character,Character[]> map){
        int len = digits.length();
        Queue<String> q = new LinkedList<>();
        q.add("");
        for (int i = 0; i < len; i++) {
            char ch = digits.charAt(i);
            if(map.containsKey(ch)){
                while(!q.isEmpty() && q.peek().length()<=i){
                    String str = q.poll();
                    for (Character cur : map.get(ch)) {
                        q.add(str+cur);
                    }
                }
            }
        }
        while(!q.isEmpty()){
            list.add(q.poll());
        }
    }
}
