package offer;
// 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
// 例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数
public class 丑数 {
    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(224));
        System.out.println(GetUglyNumber_Solution1(224));
        System.out.println(GetUglyNumber_Solution2(224));
    }

    //  自己写了前半个，对于丑数的判断参看了剑指offer,丑数指的是只能被2、3、5这几个数整除的数
    public static int GetUglyNumber_Solution1(int index) {
        if(index == 1) return 1;
        int idx = 1;
        int num = 1;
        while(idx < index){
            idx++;
            num++;
            while(!isUgly(num)){
                num++;
            }
        }
        return num;
    }

    public static boolean isUgly(int num){
        while(num%2 == 0 ){
            num = num/2;
        }
        while(num %3 == 0){
            num = num /3;
        }
        while(num % 5 == 0){
            num = num /5;
        }
        return num == 1? true:false;
    }

    // other === 动态规划
    public static int GetUglyNumber_Solution2(int index) {
        if(index < 0) return 0;
        int[] res = new int[index];
        res[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0; // 三个指针分别对应着x2、x3、x5的位置移动
        for (int i = 1; i < index; i++) {
            res[i] = Math.min(res[p2]*2,Math.min(res[p3]*3,res[p5]*5));
            if(res[i] == res[p2]*2) p2++;
            if(res[i] == res[p3]*3) p3++;
            if(res[i] == res[p5]*5) p5++;
        }
        return res[index-1];
    }
    public static int GetUglyNumber_Solution(int index) {
        if(index <= 0)return 0;
        int p2=0,p3=0,p5=0;//初始化三个指向三个潜在成为最小丑数的位置
        int[] result = new int[index];
        result[0] = 1;//
        for(int i=1; i < index; i++){
            result[i] = Math.min(result[p2]*2, Math.min(result[p3]*3, result[p5]*5));
            if(result[i] == result[p2]*2)p2++;//为了防止重复需要三个if都能够走到
            if(result[i] == result[p3]*3)p3++;//为了防止重复需要三个if都能够走到
            if(result[i] == result[p5]*5)p5++;//为了防止重复需要三个if都能够走到


        }
        return result[index-1];
    }
}
