package primary.courseseven.self;

import java.util.Arrays;
import java.util.Comparator;

//    一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。
//    给你每一个项目开始的时间和结束的时间(给你一个数组，里面是一个个具体的项目)，
//    你来安排宣讲的日程，要求会议室进行的宣讲的场次最多。
//    返回这个最多的宣讲场次。
public class BestArrange {

    public static class Program{
        int start;
        int end;

        public Program(int s,int e){
            this.start = s;
            this.end = e;
        }
    }

    public static class EndtimeComparator implements Comparator<Program>{
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public static int bestArrange(Program[] p){
        if(p == null) return 0;
        int times = 0;
        Arrays.sort(p,new EndtimeComparator());
        int endtime = 0;
        for (int i = 0; i < p.length; i++) {
            if(p[i].start >= endtime){
                times++;
                endtime = p[i].end;
            }
        }
        return times;
    }

    public static Program[] makeP(int[] s,int[] e){
        Program[] p = new Program[s.length];
        for (int i = 0; i < s.length; i++) {
            p[i] = new Program(s[i],e[i]);
        }
        return p;
    }

    public static void main(String[] args) {
        int[] starts = new int[]{12,11,13,14,13};
        int[] ends = new int[]{13,13,14,15,15};

        Program[] programs = makeP(starts, ends);
        System.out.println("最多可安排的场次为："+bestArrange(programs));

    }
}
