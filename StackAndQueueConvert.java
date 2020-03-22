package primary.coursethree.selfcode;

import javax.print.DocFlavor;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//如何仅用队列结构实现栈结构？ 如何仅用栈结构实现队列结构
public class StackAndQueueConvert {
    public static class TwoStackToQueue{
        private Stack<Integer> pushStack;
        private Stack<Integer> popStack;

        public TwoStackToQueue(){
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }

        public void push(Integer num){
            this.pushStack.push(num);
        }

        public Integer poll(){
            if(this.pushStack.isEmpty() && this.popStack.isEmpty()){
                throw new ArrayIndexOutOfBoundsException("The Queue is empty");
            }else if(this.popStack.isEmpty()){
                while(!this.pushStack.isEmpty()){
                    this.popStack.push(this.pushStack.pop());
                }
            }
            return popStack.pop();
        }

        public Integer peek(){
            if(this.pushStack.isEmpty() && this.popStack.isEmpty()){
                return null;
            }else if(this.popStack.isEmpty()){
                while(!this.pushStack.isEmpty()){
                    this.popStack.push(this.pushStack.pop());
                }
            }
            return popStack.peek();
        }
    }

    public static class TwoQueueToStack{
        private Queue<Integer> queue;
        private Queue<Integer> help;

        public TwoQueueToStack(){
//            queue = new Queue<Integer>();
            queue = new LinkedList<>();  //注意这里用的是LinkedList
            help = new LinkedList<>();
        }

        public void push(Integer num){
            queue.add(num);
        }

        public Integer pop(){
            if(this.queue.isEmpty()){
                throw new ArrayIndexOutOfBoundsException("The Stack is empty");
            }
            while(queue.size()!=1){
                this.help.add(this.queue.poll());
            }
            int value = queue.poll();
            swap();
            return value;
        }

        public Integer peek(){
            if(this.queue.isEmpty()){
                return null;
            }
            while(queue.size()!=1){
                this.help.add(this.queue.poll());
            }
            int value = queue.poll();
            this.help.add(value);
            swap();
            return value;
        }

        public void swap(){
            Queue<Integer> tmp = new LinkedList<>();
            tmp = this.queue;
            this.queue = this.help;
            this.help = tmp;
        }

    }

    public static void main(String[] args) {
        TwoStackToQueue queue = new TwoStackToQueue();
        queue.push(3);
        queue.push(6);
        queue.push(9);
        System.out.println(queue.peek()); // 3
        queue.poll();
        System.out.println(queue.peek()); // 6

        System.out.println("==========================");

//        Queue<Integer> que = new LinkedList<>();
//        que.add(1);
//        System.out.println(que); // [1]
//        Queue<Integer> tmp = que;
//        System.out.println(tmp);
        TwoQueueToStack stack = new TwoQueueToStack();
        stack.push(3);
        stack.push(5);
        stack.push(7);
//        System.out.println(stack);
//        //primary.coursethree.selfcode.StackAndQueueConvert$TwoQueueToStack@2f4d3709
        System.out.println(stack.peek()); // 7
        stack.pop();
        System.out.println(stack.peek()); // 5

    }
}
