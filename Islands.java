package primary.coursefive.selfcode;
//岛问题
//        一个矩阵中只有0和1两种值，
//        每个位置都可以和自己的上、下、左、右 四个位置相连，
//        如果有一片1连在一起，
//        这个部分叫做一个岛，
//        求一个 矩阵中有多少个岛？

public class Islands {
    public static void main(String[] args) {
        int[][] isLand1 = new int[][]{  {1, 0, 0, 1},
                                        {1, 0, 1, 1},
                                        {0, 0, 1, 0} };
        System.out.println("含有岛的数量为："+isLandNum(isLand1));
    }

    public static int isLandNum(int[][] island){
        if(island == null || island[0] == null){
            return 0;
        }
        int nrow = island.length;
        int ncol = island[0].length;
        int count = 0;
        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                if( island[i][j] == 1){
                    infect(island,i,j,nrow,ncol);
                    count++;
                }
            }
        }
        return count;
    }

    public static void infect(int[][] island ,int i,int j, int nrow ,int ncol){
        // 感染结束的条件
        if( i >= nrow || j >= ncol || i < 0 || j < 0 || island[i][j]!=1)
            return;
        island[i][j] = 2;
        infect(island,i+1,j,nrow,ncol);
        infect(island,i,j+1,nrow,ncol);
        infect(island,i-1,j,nrow,ncol);
        infect(island,i,j-1,nrow,ncol);

    }
}
