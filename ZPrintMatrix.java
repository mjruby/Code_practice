package primary.coursethree.selfcode;
//“之”字形打印矩阵
////【题目】 给定一个矩阵matrix，按照“之”字形的方式打印这 个矩阵，
////        例如： 1   2   3   4  5   6   7   8  9  10  11  12
////        “之”字形打印的结果为：1，2，5，9，6，3，4，7，10，11， 8，12
////        【要求】 额外空间复杂度为O(1)。

// 问题： A(tR,tC) B(dR,dC)
public class ZPrintMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        printMatrix(matrix);

        System.out.println("===============================");
        Z_PrintMatrix(matrix);
    }

    public static void Z_PrintMatrix(int[][] matrix){
        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length -1;
        boolean fromUp = false;

        while(tR <= endR){
            printLevel(matrix,tR,tC,dR,dC,fromUp);
            tR = tC == endC ? tR + 1 : tR;  //1
            tC = tC == endC ? tC : tC + 1;  //2
            dC = dR == endR ? dC + 1 : dC;  //4
            dR = dR == endR ? dR : dR + 1;  //3
// 【关键点： 原本写的顺序是1，2，3，4，但是一直报错。
// 最后发现，前两行比较的条件有tC，所以关于tC的加（第2行）放在后面；
// 后两行的判断条件有dR,也将关于dR的操作放后】
            fromUp = !fromUp;
        }
        System.out.println();
    }

    public static void printLevel(int[][] matrix, int tR,int tC,int dR,int dC,boolean fromUp){
        if(fromUp){
            while(tR <= dR){  // tR <= dR
                System.out.print(matrix[tR++][tC--]+" ");
            }
        }else{
            while(dR >= tR){  // dR >= tR
                System.out.print(matrix[dR--][dC++]+" ");
            }
        }
    }

    public static void printMatrix(int[][] matrix){
        int nrow = matrix.length;
        int ncol = matrix[0].length;

        for(int i=0; i<nrow; i++){
            for(int j =0;j<ncol; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
