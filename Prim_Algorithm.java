package fanli.selfcode.prim;
// 应用场景-修路问题

import java.util.Arrays;

// 在包含n个顶点的连通图中，找出只有(n-1)条边包含所有n个顶点的连通子图，也就是所谓的极小连通子图
// 寻找连接n个顶点的，n-1条权值和最小的最小生成树 --- 从点出发
public class Prim_Algorithm {
    public static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int n = 7;
        char[] vetexs = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] weight = new int[][]{
                {INF, 5, 7, INF, INF, INF, 2},
                {5, INF, INF, 9, INF, INF, 3},
                {7, INF, INF, INF, 8, INF, INF},
                {INF, 9, INF, INF, INF, 4, INF},
                {INF, INF, 8, INF, INF, 5, 4},
                {INF, INF, INF, 4, 5, INF, 6},
                {2, 3, INF, INF, 4, 6, INF}};
        Graph gp = new Graph(n);
        gp.addVertexs(vetexs);
        gp.addWeighs(weight);
        gp.printGraph();

        prim(gp);
    }

    // prim
    public static void prim(Graph gp){
        char[] vertexs = gp.getVertexs();
        int n = vertexs.length;
        int[][] weights = gp.getWeights();
        int[] visited = new int[vertexs.length]; // 用于标记是否已加入

        visited[0] = 1;  // 从第一个点出发，标记为1

        int times = n;
        while (times > 1) {  // 因为只会有 n-1 条边
            int min_weight = Integer.MAX_VALUE;
            int index_i = 0;
            int index_j = 0;
            for (int i = 0; i < n; i++) {
                if(visited[i] == 1){
                    for (int j = 0; j < n; j++) {
                        if( visited[j] == 0 && weights[i][j]<min_weight){
                            min_weight = weights[i][j];
                            index_i = i;
                            index_j = j;
                        }
                    }
                }
            }
            times--;
            visited[index_j] = 1;
            System.out.println("边<"+vertexs[index_i]+","+vertexs[index_j]+">  权值为："+weights[index_i][index_j]);
        }
    }

}

class Graph {
    private char[] vertexs; //顶点
    private int[][] weights; // 各边权重
    private int n; // 顶点数

    public Graph(int num) {
        this.n = num;
        this.vertexs = new char[n];
        this.weights = new int[n][n];
    }

    public void addVertexs(char[] vertexs) {
        this.vertexs = Arrays.copyOf(vertexs, vertexs.length);
    }

    public char[] getVertexs(){
        return this.vertexs;
    }

    public void addWeighs(int[][] w) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.weights[i][j] = w[i][j];
            }
        }
    }

    public int[][] getWeights(){
        return this.weights;
    }

    public void printGraph(){
        System.out.println("连通图如下：");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%15d",this.weights[i][j]);
            }
            System.out.println();
        }
    }
}