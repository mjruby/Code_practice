package fanli.selfcode.prim;
// Ӧ�ó���-��·����

import java.util.Arrays;

// �ڰ���n���������ͨͼ�У��ҳ�ֻ��(n-1)���߰�������n���������ͨ��ͼ��Ҳ������ν�ļ�С��ͨ��ͼ
// Ѱ������n������ģ�n-1��Ȩֵ����С����С������ --- �ӵ����
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
        int[] visited = new int[vertexs.length]; // ���ڱ���Ƿ��Ѽ���

        visited[0] = 1;  // �ӵ�һ������������Ϊ1

        int times = n;
        while (times > 1) {  // ��Ϊֻ���� n-1 ����
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
            System.out.println("��<"+vertexs[index_i]+","+vertexs[index_j]+">  ȨֵΪ��"+weights[index_i][index_j]);
        }
    }

}

class Graph {
    private char[] vertexs; //����
    private int[][] weights; // ����Ȩ��
    private int n; // ������

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
        System.out.println("��ͨͼ���£�");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%15d",this.weights[i][j]);
            }
            System.out.println();
        }
    }
}