package offer;

import java.util.Stack;

// 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
//注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
public class 包含min函数的栈 {
    public static void main(String[] args) {
        newStack ns = new newStack();
        ns.push(7);
        ns.push(3);
        ns.push(1);
        System.out.println(ns.min());
        ns.push(1);
        ns.push(5);
        System.out.println(ns.min());
        ns.pop();
        ns.pop();
        System.out.println(ns.min());
        ns.pop();
        System.out.println(ns.min());
        ns.push(7);
    }
}

class newStack{
    Stack<Integer> st = new Stack<>();
    Stack<Integer> st_min = new Stack<>();

    public void push(int node) {
        st.add(node);
        if(st_min.isEmpty()) st_min.add(node);
        else {
            if(node <= st_min.peek()) st_min.add(node);
        }
    }

    public void pop() {
        Integer node = st.pop();
        if(node == st_min.peek()) st_min.pop();
    }

    public int top() {
        return st.peek();
    }

    public int min() {
        return st_min.peek();
    }
}