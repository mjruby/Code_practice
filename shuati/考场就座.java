package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

public class 考场就座 {
    public static void main(String[] args) {
//        ExamRoom ex = new ExamRoom(10);
//        System.out.println(ex.seat());  // 0
//        System.out.println(ex.seat());  // 9
//        System.out.println(ex.seat());  // 4
//        System.out.println(ex.seat());  // 2
//        ex.leave(4);
//        System.out.println(ex.seat());  // 5

        // ["ExamRoom","seat","seat","seat","leave","leave"]
        //[[10],[],[],[],[0],[4]]
        ExamRoom ex = new ExamRoom(4);
        System.out.println(ex.seat());
        System.out.println(ex.seat());
        System.out.println(ex.seat());
        System.out.println(ex.seat());
        ex.leave(0);
        System.out.println(ex.seat());
        ex.leave(4);
    }
}


class ExamRoom {
    int total_N;
    HashMap<Integer,int[]> startMap;
    HashMap<Integer,int[]> endMap;
    TreeSet<int[]> tree;

    public ExamRoom(int N) {
        this.total_N = N;
        startMap = new HashMap<>();
        endMap = new HashMap<>();

        tree = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int dist1 = distance(o1);
                int dist2 = distance(o2);
                if(dist1 == dist2)
                    return o2[0]-o1[0];
                return dist1 - dist2;
            }
        });

        tree.add(new int[]{-1,total_N});
    }

    public int seat() {
        int[] longest = tree.last();
        int start = longest[0];
        int end = longest[1];
        int seat = 0;

        if(start == -1){
            seat = 0;
        }else if(end == total_N){
            seat = total_N-1;
        }else {
            seat = start + (end - start) / 2;
        }

        int[] left = new int[]{start,seat};
        int[] right = new int[]{seat,end};
        removeInterval(longest);
        insertInterval(left);
        insertInterval(right);
        return seat;
    }

    public void leave(int p) {

        int[] left = endMap.get(p);
        int[] right = startMap.get(p);
        mergeInterval(left,right);
    }

    public int distance(int[] points){
        int x = points[0];
        int y = points[1];
        if(x == -1) return y;
        if(y == total_N) return y - x - 1;

        return (y-x)/2;
    }

    public void insertInterval(int[] intv){
        int x = intv[0];
        int y = intv[1];
        tree.add(intv);
        startMap.put(x,intv);
        endMap.put(y,intv);
    }

    public void removeInterval(int[] intv){
        int x = intv[0];
        int y = intv[1];
        tree.remove(intv);
        startMap.remove(x);
        endMap.remove(y);
    }

    public void mergeInterval(int[] intv1,int[] intv2){
        int x = intv1[0];
        int y = intv2[1];
        int[] newIntv = new int[]{x,y};
        removeInterval(intv1);
        removeInterval(intv2);
        insertInterval(newIntv);
    }
}