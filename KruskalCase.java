package fanli.selfcode.kruskal;
// 克鲁斯卡尔算法

// 按照权值从小到大的顺序选择n-1条边，并保证这n-1条边不构成回路
// 不构成回路 -- 使用并查集

//        边<E,F>  权值为：2
//        边<C,D>  权值为：3
//        边<D,E>  权值为：4
//        边<B,F>  权值为：7
//        边<E,G>  权值为：8
//        边<A,B>  权值为：12

import java.util.*;


public class KruskalCase {
    public static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int weights[][] = {
                        /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {   0,  12, INF, INF, INF,  16,  14},
                /*B*/ {  12,   0,  10, INF, INF,   7, INF},
                /*C*/ { INF,  10,   0,   3,   5,   6, INF},
                /*D*/ { INF, INF,   3,   0,   4, INF, INF},
                /*E*/ { INF, INF,   5,   4,   0,   2,   8},
                /*F*/ {  16,   7,   6, INF,   2,   0,   9},
                /*G*/ {  14, INF, INF, INF,   8,   9,   0}};
        MinTree minTree = new MinTree();
        PriorityQueue<Edge> tmp_PQ = minTree.getEdges(weights,vertexs,INF);
        System.out.println(tmp_PQ);

        vertexU_F vertexCheck = new vertexU_F(vertexs);
        minTree.kruskalAlg(tmp_PQ,vertexCheck);
    }


}

class MinTree{

    // 根据权值大小的比较器 -- 从小到大
    public class weightComparator implements Comparator<Edge>{
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    // 由邻接矩阵获得有效的边
    public PriorityQueue<Edge> getEdges(int[][] weights,char[] vertexs, Integer inf){
        PriorityQueue<Edge> pQ = new PriorityQueue<>(new weightComparator());
        int n = vertexs.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(weights[i][j] < inf){
                    pQ.offer(new Edge(vertexs[i],weights[i][j],vertexs[j]));
                }
            }
        }
        return pQ;
    }

    public void kruskalAlg(PriorityQueue<Edge> pQ,vertexU_F vertexCheck){
        Edge firstE = pQ.poll();
        Character ver1 = firstE.start;
        Character ver2 = firstE.end;
        while (pQ.size() > 0){
            if(!vertexCheck.isSameUnion(ver1,ver2)){  //
                System.out.println("边<"+ver1+","+ver2+">  权值为："+firstE.weight);
                vertexCheck.unionSets(ver1,ver2);
            }
            firstE = pQ.poll();
            ver1 = firstE.start;
            ver2 = firstE.end;
        }
    }

}

// 构造查集基础
class vertexU_F{
    HashMap<Character,Character> fatherMap;
    HashMap<Character,Integer> sizeMap;

    public vertexU_F(char[] arr){
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
        for (char c : arr) {
            fatherMap.put(c,c);
            sizeMap.put(c,1);
        }
    }

    // 判断两个点是否属于同一集合
    public boolean isSameUnion(char a, char b){
        return getFather(a) == getFather(b);
    }

    // 获得一个点的父节点
    public char getFather(char a){
        char father = fatherMap.get(a);
        if(father != a){
            father = getFather(father);
        }
        fatherMap.put(a,father);
        return father;
    }

    // 合并两个结点所在集合
    public void unionSets(char a ,char b){
        char father_a = getFather(a);
        char father_b = getFather(b);
        int size_a = sizeMap.get(father_a);
        int size_b = sizeMap.get(father_b);
        if(size_a > size_b){
            fatherMap.put(b,a);
            sizeMap.put(a,size_a+size_b);
        }else {
            fatherMap.put(a,b);
            sizeMap.put(b,size_a+size_b);
        }
     }
}
class Edge{
    char start;
    int weight;
    char end;

    public Edge(char start,int w,char end){
        this.start = start;
        this.weight = w;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "start=" + start +
                ", weight=" + weight +
                ", end=" + end +
                '}';
    }
}

