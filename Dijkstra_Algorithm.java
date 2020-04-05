package fanli.selfcode.dijkstra;

import java.util.Arrays;

// �Ͻ�˹�����㷨����·�����ȵ����������·��
public class Dijkstra_Algorithm {
    public static void main(String[] args) {
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;// ��ʾ����������
        matrix[0]=new int[]{0,5,7,N,N,N,2};
        matrix[1]=new int[]{5,0,N,9,N,N,3};
        matrix[2]=new int[]{7,N,0,N,8,N,N};
        matrix[3]=new int[]{N,9,N,0,N,4,N};
        matrix[4]=new int[]{N,N,8,N,0,5,4};
        matrix[5]=new int[]{N,N,N,4,5,0,6};
        matrix[6]=new int[]{2,3,N,N,4,6,0};
        Graph gp = new Graph(vertex,matrix);
        gp.showGraph();

        Node node = new Node(matrix);
        node.dijkstra(2,matrix);
        System.out.println(Arrays.toString(node.visited));
        System.out.println(Arrays.toString(node.dist));
        System.out.println(Arrays.toString(node.parent));
    }
}

class Node{
    boolean[] visited; // �洢�Ƿ����Ѿ�������·���Ľ��
    int[] dist; // �洢���㵽������ľ���
    int[] parent; // �洢����ĸ��ڵ�

    public Node(int[][] w){
        int n = w.length;
        visited = new boolean[n]; // false
        dist = new int[n];
        parent = new int[n];

        // ��ʼ��dist final int N = 65535;// ��ʾ����������
        final int N = 65535;
        for(int i=0;i<n;i++){
            dist[i] = N;
        }

        // ��ʼ��parent Ϊ-1���������parent�������Լ�
        for(int i=0;i<n;i++){
            parent[i] = -1;
        }

    }

    // ���������
    public void addFirstNode(int index,int[][] w){
        dist[index] = 0;
        visited[index] = true;
        for (int i = 0; i < visited.length; i++) {
            this.dist[i] = w[index][i];
            parent[i] = index;
        }
    }

    // ��ʽ
    public void dijkstra(int index,int[][] w){
        int times = w.length;
        addFirstNode(index,w);
        while (times > 1){
            int minIndex = scanMinIndex();
            updateAll(minIndex,w);
            times--;
        }
    }

    public int scanMinIndex(){
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;
        for(int i=0;i<visited.length;i++){
            if(visited[i] == false && dist[i] < minValue){
                minIndex = i;
                minValue = dist[i];
            }
        }
        return minIndex;
    }

    public void updateAll(int minIndex,int[][] w){
        visited[minIndex] = true;
        for(int i=0;i<visited.length;i++){
            if((visited[i]== false) && ((w[minIndex][i] + dist[minIndex]) < dist[i])){
                dist[i] = (w[minIndex][i] + dist[minIndex]);
                parent[i] = minIndex;
            }
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