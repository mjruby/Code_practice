package offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

// 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
// 假设压入栈的所有数字均不相等。
// 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
// 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
public class 栈的压入弹出序列 {
    public static void main(String[] args) {
        /*int[] pushA = {1, 2, 3, 4, 5};
        int[] popA1 = {4, 5, 3, 2, 1};
        boolean b = IsPopOrder(pushA, popA1);
        System.out.println(b);

        int[] popA2 = {4, 3, 5, 1, 2};
        System.out.println(IsPopOrder(pushA, popA2));
*/
        int[] pushb = {1, 2};
        int[] popb = {1, 2};
        System.out.println(IsPopOrder(pushb, popb));

        int[] popb1 = {2, 1};
        System.out.println(IsPopOrder(pushb, popb1));

        int[] pushc = {1};
        int[] popc = {1};
        System.out.println(IsPopOrder(pushc, popc));

    }

    // 自己的 -- 有点复杂
    public static boolean IsPopOrder1(int[] pushA, int[] popA) {
        // popA中每一个数a，比如是4，pushA中在4左边的123，在popA中必须在其右边且排序是321
        int len = popA.length;
        if (len == 0) return true;
        if (len == 1 && popA[0] != pushA[0]) return false;
        HashMap<Integer, Integer> map_push = new HashMap<>();
        HashMap<Integer, Integer> map_pop = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map_push.put(pushA[i], i);
            map_pop.put(popA[i], i);
        }
        for (int i = 0; i < len; i++) {
            int tmp = popA[i];
            // list 存放tmp左边的数
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = i + 1; j < len; j++) {
                if (map_push.get(popA[j]) < map_push.get(tmp))
                    list.add(popA[j]);
            }
            int len_list = list.size();
            for (int k = 0; k < len_list; k++) {
                Integer val = list.remove(0);
                if (map_push.get(tmp) < map_push.get(val))
                    return false;
                tmp = val;
            }
        }
        return true;
    }

    // other
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        int len = pushA.length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0, j = 0; i < len; i++) {
            st.add(pushA[i]);
            while (j < len && !st.isEmpty() && st.peek() == popA[j]) {
                st.pop();
                j++;
            }
        }
        return st.isEmpty();
    }
}
