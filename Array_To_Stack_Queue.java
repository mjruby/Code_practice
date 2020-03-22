package primary.coursethree.selfcode;

import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

// 用数组结构实现大小固定的队列和栈
public class Array_To_Stack_Queue {
    public static class ArrayStack{
        private int[] arr;
        private int size;

        public ArrayStack(int arrlength) {
            if(arrlength < 0)
                throw new IllegalArgumentException("Stack 的长度不符合要求！");
            arr = new int[arrlength];
            size = 0;
        }

        public void push(int num){
            if(size == arr.length){
                throw new ArrayIndexOutOfBoundsException("Stack is full");
            }
            arr[size++] = num;
        }

        public int pop(){
            if(size == 0){
                throw new ArrayIndexOutOfBoundsException("Stack is empty");
            }
            return arr[--size];
        }

        public Integer peek(){  // 设置为 int 时是不能return null的。 Integer可以
            if(size == 0){
                return null;   // 就是没有输出
            }
            return arr[size-1];
        }

    }

    public static class ArrayQueue{
        private Integer[] arr;
        private Integer size;
        private Integer first;
        private Integer last;

        public ArrayQueue(Integer arrLength){
            if(arrLength < 0){
                throw new IllegalArgumentException("The num is illegal");
            }
            arr = new Integer[arrLength];
            size = 0;
            first = 0;
            last = 0;
        }

        public void push(Integer num){
            if(size == arr.length){
                throw new ArrayIndexOutOfBoundsException("The Queue is full");
            }
            arr[last] = num;
            last = last==arr.length -1? 0 : last+1; // 注意是arr.length -1
            size++;
        }

        public Integer poll(){
            if(size == 0){
                throw new ArrayIndexOutOfBoundsException("The Queue is empty");
            }
            int tmp = first;
            first = first == arr.length-1?0:first+1;
            size--;
            return arr[tmp];

        }

        public Integer peek(){
            if(size == 0){
                return null;
            }
            return arr[first];
        }
    }
    public static void main(String[] args) {
        //正常的栈的使用
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(3);
        System.out.println(stack); // [1, 3]
        System.out.println(stack.peek()); // 3
        System.out.println("=====================================");
       // Queue<Integer> q = new Queue<Integer>(); 不行？

        //自己用数组定义的栈
        ArrayStack arrStack = new ArrayStack(3);
        arrStack.push(5);
        arrStack.push(10);
       // System.out.println(arrStack.peek());
        arrStack.push(8);
        System.out.println(arrStack.pop());
        System.out.println(arrStack.pop());
        System.out.println(arrStack.pop());

        System.out.println("=====================================");
        ArrayQueue arrQue = new ArrayQueue(3);
        arrQue.push(3);
        arrQue.push(6);
        arrQue.push(4);
        System.out.println(arrQue.poll());
        arrQue.push(4);
        System.out.println(arrQue.poll());
    }
}
