package fanli.selfcode.dijkstra;

import java.util.Arrays;

// 迪杰斯特拉算法：按路径长度递增产生最短路径
public class Dijkstra_Algorithm {
    public static void main(String[] args) {
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;// 表示不可以连接
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
    boolean[] visited; // 存储是否是已经求得最短路径的结点
    int[] dist; // 存储各点到出发点的距离
    int[] parent; // 存储各点的父节点

    public Node(int[][] w){
        int n = w.length;
        visited = new boolean[n]; // false
        dist = new int[n];
        parent = new int[n];

        // 初始化dist final int N = 65535;// 表示不可以连接
        final int N = 65535;
        for(int i=0;i<n;i++){
            dist[i] = N;
        }

        // 初始化parent 为-1，出发点的parent会是它自己
        for(int i=0;i<n;i++){
            parent[i] = -1;
        }

    }

    // 加入出发点
    public void addFirstNode(int index,int[][] w){
        dist[index] = 0;
        visited[index] = true;
        for (int i = 0; i < visited.length; i++) {
            this.dist[i] = w[index][i];
            parent[i] = index;
        }
    }

    // 正式
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
        System.out.println("图的邻接矩阵为：");
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