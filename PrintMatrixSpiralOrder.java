package primary.coursethree.selfcode;
// 转圈打印矩阵
public class PrintMatrixSpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printMatrix(matrix);
        System.out.println("====================================");
        printSpiral(matrix);
    }

    public static void printSpiral(int[][] matrix){
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while(tR <= dR && tC <= dC){
            printEdge(matrix,tR++,tC++,dR--,dC--);
        }

    }
    public static void printEdge(int[][] matrix,int tR, int tC,int dR,int dC){
        if((tC == dC)&&(tR <= dR)){
            System.out.print(matrix[tR++][tC]+ " ");
            return;
        }else if((tC <= dC)&&(tR == dR)){
            System.out.print(matrix[tR][tC++]+" ");
            return;
        }
        int curC = tC;
        int curR = tR;
        while(curC < dC){
            System.out.print(matrix[tR][curC++]+" ");
        }
        while(curR < dR){
            System.out.print(matrix[curR++][dR]+" ");
        }
        while(curC > tC){
            System.out.print(matrix[dR][curC--]+" ");
        }
        while(curR > tR){
            System.out.print(matrix[curR--][tC]+" ");
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
