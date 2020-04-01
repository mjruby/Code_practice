package fanli.selfcode.graph;
// 构建一个图，使用邻近矩阵

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int[][] neighborMatrix;
    private ArrayList<String> vertexSet;
    private boolean[] visited;
    private boolean[] visited_bfs;

    public Graph(int n){
        neighborMatrix = new int[n][n];
        vertexSet = new ArrayList<String>();
        visited = new boolean[n];
        visited_bfs = new boolean[n];
    }

    // 插入顶点
    public void insertVertex(String vertex){
        this.vertexSet.add(vertex);
    }
    // 插入边
    public void insertEdges(int i, int j, int isEdge){
        this.neighborMatrix[i][j] = isEdge;
        this.neighborMatrix[j][i] = isEdge;
    }
    // 展示图
    public void showGraph(){
        for(int[] k : neighborMatrix){
            System.out.println(Arrays.toString(k));
        }
    }
    // 找一个结点的邻居结点
    public int nextNeigh(int index){
        for(int i=0;i<vertexSet.size();i++){
            if(neighborMatrix[index][i] !=0 && visited[i] != true){
                return i;
            }
        }
        return -1;
    }

    // 深度优先
    public void dfs(boolean[] visited,int index){
        System.out.print(this.vertexSet.get(index)+" --> ");
        visited[index] = true;
        int next = nextNeigh(index);
        if(next != -1){
            dfs(visited,next);
        }
    }

    public void dfs(){
        for(int index =0;index < this.vertexSet.size();index++){
            if(visited[index] != true){
                dfs(visited,index);
            }
        }
    }

    // 广度优先
    public void bfs(boolean[] visited, int index){
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        while(!q.isEmpty()){
            int tmp = q.poll();
            System.out.print(vertexSet.get(index)+" ==> ");
            visited[tmp] = true;
            int next = nextNeigh(tmp);
            while (next != -1){
                System.out.print(vertexSet.get(next)+" ==> ");
                q.add(next);
                visited[next] = true;
                next = nextNeigh(next);
            }
        }
    }

    public void bfs(){
        for(int i=0;i<vertexSet.size();i++){
            if(visited_bfs[i] != true){
                bfs(visited_bfs,i);
            }
        }
    }

    public static void main(String[] args) {
        Graph gp = new Graph(5);
        String[] arrV = new String[]{"A","B","C","D","E"};
        for(String arr : arrV){
            gp.insertVertex(arr);
        }
        // 插入连接的点
        gp.insertEdges(0,1,1);
        gp.insertEdges(0,2,1);
        gp.insertEdges(1,2,1);
        gp.insertEdges(1,3,1);
        gp.insertEdges(1,4,1);

//        Graph gp = new Graph(11);
//        String[] arrV = new String[]{"0","1","2","3","4","5","6","7","8","9","10"};
//        for(String arr : arrV){
//            gp.insertVertex(arr);
//        }
//        // 插入连接的点
//        gp.insertEdges(0,1,1);
//        gp.insertEdges(0,2,1);
//        gp.insertEdges(0,3,1);
//        gp.insertEdges(0,4,1);
//        gp.insertEdges(1,7,1);
//        gp.insertEdges(1,9,1);
//        gp.insertEdges(1,4,1);
//        gp.insertEdges(3,5,1);
//        gp.insertEdges(3,6,1);
//        gp.insertEdges(4,5,1);
//        gp.insertEdges(7,8,1);
//        gp.insertEdges(7,10,1);

        gp.showGraph();
        System.out.println("============================================");

        System.out.println();
        System.out.println("深度优先遍历的结果为：");
        gp.dfs(); // 0 --> 1 --> 4 --> 5 --> 3 --> 6 --> 2 --> 7 --> 8 --> 9 --> 10 -->

        System.out.println();
        System.out.println("广度优先遍历的结果为：");
        gp.bfs(); // 0 ==> 1 ==> 2 ==> 3 ==> 4 ==> 5 ==> 6 ==> 7 ==> 8 ==> 9 ==> 10 ==>
    }

}
