package primary.coursethree.selfcode;

public class RotateMatrix {
    public static void main(String[] args) {
       int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
       printMatrix(matrix);
       rotateMatrix(matrix);
       System.out.println("====================================");
       printMatrix(matrix);
    }

    public static void rotateMatrix(int[][] matrix){
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;

        while(tR < dR){
            rotateEdge(matrix,tR++,tC++,dR--,dC--);
        }

    }

    private static void rotateEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
        int times = dC - tC;
        for(int i = 0; i < times; i++){
            int tmp = matrix[tR][tC+i];
            matrix[tR][tC+i] = matrix[dR-i][tC];
            matrix[dR-i][tC] = matrix[dR][dC-i];
            matrix[dR][dC-i] = matrix[tR+i][dC];
            matrix[tR+i][dC] = tmp;
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
