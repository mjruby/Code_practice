package demo;
//        假设你是一位很有爱的幼儿园老师，想要给幼儿园的小朋友们一些小糖果。但是，每个孩子最多只能给一块糖果。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的糖果的最小尺寸；并且每块糖果 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个糖果 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
//        注意：
//        你可以假设胃口值为正。
//        一个小朋友最多只能拥有一块糖果。
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 分糖果 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str =  sc.nextLine();
        String[] ch1 = str.split(" ");
        String str2 = sc.nextLine();
        String[] ch2 = str2.split(" ");

        int[] kids = new int[ch1.length];
        int[] sugs = new int[ch2.length];
        for (int i = 0; i < ch1.length; i++) {
            kids[i] = Integer.parseInt(ch1[i]);
        }
        for (int i = 0; i < ch2.length; i++) {
            sugs[i] = Integer.parseInt(ch2[i]);
        }

//        System.out.println(Arrays.toString(kids));
//        System.out.println(Arrays.toString(sugs));

        Arrays.sort(kids);
        Arrays.sort(sugs);
        int i = 0; int j =0;
        int len1 = kids.length;
        int len2 = sugs.length;
        int count = 0;
        while(i<len1 && j<len2 ){
            if(sugs[j] >= kids[i]){
                j++;i++;count++;
            }else {
                j++;
            }
        }
        System.out.println(count);
    }
}
