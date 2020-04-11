package offer;

import java.util.Stack;

// 用两个栈来实现一个队列，完成队列的Push和Pop操作。队列中的元素为int类型。
public class 用两个栈实现队列 {

    public static void main(String[] args) {
        Stack_Queue sq = new Stack_Queue();
        sq.push(1);
        sq.push(2);
        System.out.println(sq.pop());
    }

}

class Stack_Queue{

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.add(node);
    }

    public int pop() {
        if(stack1.isEmpty() && stack2.isEmpty()){
            return 0;
        }
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else {
            while(!stack1.isEmpty()){
                stack2.add(stack1.pop());
            }
            return stack2.pop();
        }
    }
}