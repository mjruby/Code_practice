package fanli.selfcode.horse;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

// ��ʿ����
// dfs

// �ݹ�ĺ��治���
public class HorseChessboard {
    private int[][] chessBoard;
    private boolean visited[];
    private static int lim; // ���̵�����
    private static boolean finished; // ���Ϊtrue,��ʾ�ɹ�

    public HorseChessboard(int n){
        this.chessBoard = new int[n][n];
        this.visited = new boolean[n*n];
        this.lim = n;
    }

    // ��ĳһ�����һ���ĵ㼯��
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
        // ���ﰴ��̰��˼�룬��arrList ��ÿ������������һ���ڵ㼯�ϴ�С����
        sortSet(arrList);
        while(!arrList.isEmpty()){
            Point newP = arrList.remove(0);
            if(!visited[newP.y*lim + newP.x]){
                horseChess(newP,step+1);
            }
        }


        //�ж�����Ƿ����������ʹ��   step ��Ӧ���ߵĲ����Ƚ� ��
        //���û�дﵽ���������ʾû��������񣬽�����������0
        //˵��: step < X * Y  ���������������
        //1. ���̵�Ŀǰλ��,��Ȼû������
        //2. ���̴���һ�����ݹ���

        // ����finished Ҫ�ӣ������Ǻ����
        if(step < lim*lim && !finished ){ // �������һ����ʼ����Ĳ����޷������������һ��ȡ�������ݣ�
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

    // ����
    public void sortSet(ArrayList<Point> arrList){
        arrList.sort(new sizeComparator());
    }
    // �������·��
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
        int n = 5;  // n = 4 ����Ͳ���������
        HorseChessboard horse = new HorseChessboard(n);

        System.out.println("���̵ı߳�Ϊ"+ n);
        horse.horseChess(new Point(0,0),1);
        horse.printPath();
        System.out.println("�Ƿ���ɣ�"+finished);
    }


}

