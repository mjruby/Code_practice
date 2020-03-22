package primary.courseone.selfcode;
// 给定一个数组，求如果排序后，相邻两数的最大差值，要求时间复杂度O（N），且要求不能用非基于比较的排序。
public class MaxGap {
    public static void main(String[] args) {
        int[] arr = new int[]{12,1,34,5,34,4,2,7,18,22,101};
        int max = maxGap(arr);
        System.out.println("差值最大为：" + max);
    }

    public static int maxGap(int[] arr){
        // 最大值，最小值
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxValue = Math.max(maxValue, arr[i]);
            minValue = Math.min(minValue, arr[i]);
        }

        // 如果相等直接返回
        if(maxValue == minValue){
            return 0;
        }

        // 三个长度为 arr.length+1的数组，每组表明一个‘桶’的最大值，最小值和是否为空
        int len = arr.length + 1;
        int[] maxs = new int[len];
        int[] mins = new int[len];
        boolean[] hasEle = new boolean[len];

        // 元素依次放入对应的‘桶’
        for (int i = 0; i < arr.length; i++) {
            int index = (int)((arr[i]-minValue)*(len-1)/(maxValue-minValue));
            maxs[index] = hasEle[index]?Math.max(arr[i],maxs[index]):arr[i];
            mins[index] = hasEle[index]?Math.min(arr[i],mins[index]):arr[i];
            hasEle[index] = true;
        }

        // 最大值肯定是一个桶的最大值和后来另一个非空桶的最小值直接的差值
        int gap = Integer.MIN_VALUE;
        int max = maxs[0]; //max[0]（max[len]）是肯定有元素的,存放的至少有数组的最小值
        for(int i=1;i<len;i++){
            if(hasEle[i]){
                gap = Math.max(mins[i] - max, gap);
                max = maxs[i];
            }
        }
        return gap;
    }

}
