package fanli.selfcode.horse;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

// 骑士周游
// dfs

// 递归的后面不理解
public class HorseChessboard {
    private int[][] chessBoard;
    private boolean visited[];
    private static int lim; // 棋盘的列数
    private static boolean finished; // 如果为true,表示成功

    public HorseChessboard(int n){
        this.chessBoard = new int[n][n];
        this.visited = new boolean[n*n];
        this.lim = n;
    }

    // 求某一点的下一步的点集合
    public ArrayList<Point> nextPoints(Point p){
        ArrayList<Point> arrList = new ArrayList<>();
        if(p.x-1>=0 && p.y-2>=0){
            arrList.add(new Point(p.x-1,p.y-2));
        }
        if(p.x-2>=0 && p.y-1>=0){
            arrList.add(new Point(p.x-2,p.y-1));
        }
        if(p.x+1<lim && p.y-2>=0){
            arrList.add(new Point(p.x+1,p.y-2));
        }
        if(p.x+2<lim && p.y-1>=0){
            arrList.add(new Point(p.x+2,p.y-1));
        }
        if(p.x+1<lim && p.y+2<lim){
            arrList.add(new Point(p.x+1,p.y+2));
        }
        if(p.x+2<lim && p.y+1<lim){
            arrList.add(new Point(p.x+2,p.y+1));
        }
        if(p.x-1>=0 && p.y+2<lim){
            arrList.add(new Point(p.x-1,p.y+2));
        }
        if(p.x-2>=0 && p.y+1<lim){
            arrList.add(new Point(p.x-2,p.y+1));
        }
        return arrList;
    }

    public void horseChess(Point curP,int step){
        this.chessBoard[curP.y][curP.x] = step;
        this.visited[curP.y*lim + curP.x] = true;
        ArrayList<Point> arrList = nextPoints(curP);
        // 这里按照贪心思想，给arrList 里每个结点包含的下一步节点集合大小排序，
        sortSet(arrList);
        while(!arrList.isEmpty()){
            Point newP = arrList.remove(0);
            if(!visited[newP.y*lim + newP.x]){
                horseChess(newP,step+1);
            }
        }


        //判断马儿是否完成了任务，使用   step 和应该走的步数比较 ，
        //如果没有达到数量，则表示没有完成任务，将整个棋盘置0
        //说明: step < X * Y  成立的情况有两种
        //1. 棋盘到目前位置,仍然没有走完
        //2. 棋盘处于一个回溯过程

        // 这里finished 要加，还不是很理解
        if(step < lim*lim && !finished ){ // 如果从这一步开始下面的步骤无法到达最后，则这一步取消（回溯）
            this.chessBoard[curP.y][curP.x] = 0;
            this.visited[curP.y*lim + curP.x] = false;
        }else {
            finished = true;
        }
    }

    class sizeComparator implements Comparator<Point>{
        @Override
        public int compare(Point o1, Point o2) {
            return nextPoints(o1).size() - nextPoints(o2).size();
        }
    }

    // 排序
    public void sortSet(ArrayList<Point> arrList){
        arrList.sort(new sizeComparator());
    }
    // 输出棋盘路径
    public void printPath(){
        int n = this.chessBoard.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(chessBoard[i][j]+"  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;  // n = 4 本身就不可以走完
        HorseChessboard horse = new HorseChessboard(n);

        System.out.println("棋盘的边长为"+ n);
        horse.horseChess(new Point(0,0),1);
        horse.printPath();
        System.out.println("是否完成："+finished);
    }


}

