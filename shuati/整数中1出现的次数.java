package offer;
// 从1 到 n 中1出现的次数
public class 整数中1出现的次数 {
    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(10));
    }


    // other: 个位，百位，千位依次计算
    // 个位的划分阶梯是10，eg,39可以化为0-9，10-19，20-29三个完整阶梯，每个阶梯中个位为1的出现1次（1，11，21），
    // 漏掉的数为 39 % 10 = 9 ，判断9>1,所以个位数还有一个1。总的个位数1为4
    // 十位的划分阶梯是100，217可划分为0-99，100-199,每个阶梯中十位为1的出现10次（10-19，110-119），
    // 漏掉的数为 239%100 = 17，判断17<19,所以有17-10+1=8个1.总的十位为1共有239/100*10 + 8


    public static int NumberOf1Between1AndN_Solution(int n) {
        int idx = 1; // 个位开始
        int count = 0;
        while(idx <= n){
            int div = idx * 10;  // div 阶梯划分尺度
            count += n/div * idx + Math.min(idx,Math.max(0,n%div-idx+1));
            idx = div;
        }
        return count;
    }
}
