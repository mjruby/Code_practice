package primary.coursethree.selfcode;

import java.util.Scanner;
import java.util.Stack;

public class GetMinStack {

    public static class MyStack{
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;

        public MyStack(){
            dataStack = new Stack<>();
            minStack = new Stack<>();
        }

        public Integer pop(){
            Integer value;
            if (this.dataStack.isEmpty()) {
                throw new ArrayIndexOutOfBoundsException("The stack is empty");
            }
            value = this.dataStack.pop();
            this.minStack.pop();
            return value;
        }

        public void push(Integer num){
            this.dataStack.push(num);
            if(this.minStack.isEmpty()){
                this.minStack.push(num);
            }else{
                int minValue = Math.min(this.minStack.peek(),num);
                this.minStack.push(minValue);
            }

        }

        public Integer getmin(){
            if( this.minStack.isEmpty()){
                return null;
            }
            return this.minStack.peek();
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(7);
        stack.push(5);
        stack.push(3);
        stack.pop();
        stack.pop();
        System.out.println(stack.getmin());
    }

}
