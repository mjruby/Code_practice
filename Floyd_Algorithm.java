package fanli.selfcode.floyd;

import java.util.Arrays;

// �����ÿһ�����㵽������������·����
// ���μ������������Ϊ�м��������¸�����·������
public class Floyd_Algorithm {
    public static void main(String[] args) {
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
        matrix[0] = new int[] { 0, 5, 7, N, N, N, 2 };
        matrix[1] = new int[] { 5, 0, N, 9, N, N, 3 };
        matrix[2] = new int[] { 7, N, 0, N, 8, N, N };
        matrix[3] = new int[] { N, 9, N, 0, N, 4, N };
        matrix[4] = new int[] { N, N, 8, N, 0, 5, 4 };
        matrix[5] = new int[] { N, N, N, 4, 5, 0, 6 };
        matrix[6] = new int[] { 2, 3, N, N, 4, 6, 0 };

        Graph gp = new Graph(vertex,matrix);
        Node node = new Node(matrix);
        node.floyd_Algorithm();
        node.printMatrix(vertex);
    }
}

class Node{
    int[][] path;
    int[][] parent;

    public Node(int[][] w){
        int n = w.length;
        path = new int[n][n];
        parent = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                path[i][j] = w[i][j];
                parent[i][j] = j;  // ��ע������Ĵ�����bվ�Ͽ����ġ�
            }
        }
    }

    public void floyd_Algorithm(){
        int n = parent.length;
        for (int k = 0; k < n; k++) {  // ���β����м���
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(path[i][k]+path[k][j] < path[i][j]){
                        path[i][j] = path[i][k]+path[k][j];
                        parent[i][j] = parent[i][k];   // ��������⣬����ͷ˳��β�Ϳ���֪��·��
                    }
                }
            }
        }
    }

    public void printMatrix(char[] vertexs){
        int n = parent.length;
        System.out.println("����֮��ľ������Ϊ��");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%7d",path[i][j]);
            }
            System.out.println();
        }
        System.out.println("�м侭����·���������Ϊ��");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(vertexs[parent[i][j]]+" ");
            }
            System.out.println();
        }
    }
}
class Graph{
    char[] vertexs;
    int[][] weights;

    public Graph(char[] vertex, int[][] w){
        int n = vertex.length;
        this.vertexs = new char[n];
        this.weights = new int[n][n];

        this.vertexs = Arrays.copyOf(vertex,vertex.length);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                this.weights[i][j] = w[i][j];
            }
        }
    }

    public void showGraph(){
        System.out.println("ͼ���ڽӾ���Ϊ��");
        int n = vertexs.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.printf("%10d",this.weights[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}