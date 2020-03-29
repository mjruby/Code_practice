package primary.courseeight.selfcode;
//  汉诺塔问题
//  打印n层汉诺塔从最左边移动到最右边的全部过程
public class Hanoi {

    public static void hanoi(int n ,String a,String b,String c){
        if(n == 1){
            System.out.println("Move 1 from "+a +" ===> " + c);
            return;
        }
        hanoi(n-1,a,c,b);
        System.out.println("Move "+n+" from "+a+" ===> " + c);
        hanoi(n-1,b,a,c);
    }

    public static void main(String[] args) {
        hanoi(3,"左","中","右");
    }
}
