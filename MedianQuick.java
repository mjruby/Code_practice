package primary.courseseven.self;

import class_07.Code_04_MadianQuick;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

// 一个数据流中，随时可以取得中位数
public class MedianQuick {

    public static class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static class MinHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }
    // 左边 -- maxHeap  右边 -- minHeap
    public static class MedianHold{
        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;
        public MedianHold(){
            maxHeap = new PriorityQueue<>(new MaxHeapComparator()); // 大 --> 小
            minHeap = new PriorityQueue<>(new MinHeapComparator()); // 小 --> 大
        }

        public void addNumber(int num){
            if(this.minHeap.isEmpty()){
                this.minHeap.add(num);
                return;
            }
            if(this.minHeap.peek() > num){
                this.maxHeap.add(num);
            }else{
                this.minHeap.add(num);
            }
            // 调整两队列
            adjustMaxAndMin_Heap();
        }

        public void adjustMaxAndMin_Heap(){ // 左右两边差额超过一个要调整
            int maxSize = maxHeap.size();
            int minSize = minHeap.size();
            if(maxSize - minSize > 1){
                this.minHeap.add(this.maxHeap.poll());
            }
            if(minSize - maxSize > 1){
                this.maxHeap.add(this.minHeap.poll());
            }
        }

        public double getMedian(){
            int maxSize = maxHeap.size();
            int minSize = minHeap.size();
            if(maxSize == minSize){
                return (maxHeap.peek() + minHeap.peek())/2.0;
            }else{
                return maxSize > minSize? maxHeap.peek():minHeap.peek();
            }
        }
    }

    // for test
    public static int[] getRandomArr(int maxLen, int maxValue){
        int len = (int)(Math.random()*maxLen) +1;
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*maxValue);
        }
        return arr;
    }

    // for test
    public static double getMedianValue(int[] array){
        int m = array.length / 2;
        int[] arr = Arrays.copyOf(array, array.length);  // 学习了
        Arrays.sort(arr);
        if((arr.length & 1) == 1){
            return arr[m];
        }else{
            return  (arr[m] + arr[m-1])/2.0;
        }
    }

    public static void printArray(int[] arr){
        if(arr == null) return;
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
      int times = 100;
      boolean err = false;
      int len = 30;  int maxValue = 120;
        for (int i = 0; i < times; i++) {
            int[] arr = getRandomArr(len, maxValue);
            MedianHold medianH = new MedianHold();
            for (int m : arr) {
                medianH.addNumber(m);
            }
            if( getMedianValue(arr) != medianH.getMedian()){
                err = true;
                printArray(arr);
                System.out.println("第"+i+"次，test方法结果："+ getMedianValue(arr));
                System.out.println("要验的方法结果：" +medianH.getMedian());
                break;
            }
        }
        System.out.println(err? "This is an error":"Perfect");

    }
}
