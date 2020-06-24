package offer;

import java.lang.reflect.Array;
import java.util.ArrayList;

// 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
public class 和为S的连续正数序列 {
    public static void main(String[] args) {
        System.out.println(FindContinuousSequence(2));
    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> ls = new ArrayList<>();
        int first = 1;
        int second = 2;
        int res = first + second;
        while(first <= (sum/2)){
            if(res < sum){
                second++;
                res+=second;
            }else if(res > sum){
                res-=first;
                first++;
            }else {
                addFirstToSecond(ls,first,second);
                list.add(new ArrayList<>(ls)); // list.add(ls); 需要重新new ,要不然保存的就是通过一个ls内容
                res-=first;
                first++;
            }
        }
        return list;
    }

    public static void addFirstToSecond(ArrayList<Integer> rs,int first,int second){
        rs.clear();
        for (int i = first; i <= second; i++) {
            rs.add(i);
        }
    }
}
