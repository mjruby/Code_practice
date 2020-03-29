package primary.courseseven.self;

import java.util.Comparator;
import java.util.PriorityQueue;

// costs[i]表示i号项目的花费
// profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)
// k表示你不能并行、只能串行的最多做k个项目
// m表示你初始的资金
public class IPO {
    public static class Program{
        public int cost;
        public int profit;

        public Program(int cost, int profit){
            this.cost = cost;
            this.profit = profit;
        }
    }

    public static class costAscendComparetor implements Comparator<Program>{

        @Override
        public int compare(Program o1, Program o2) {
            return o1.cost - o2.cost;
        }
    }

    public static class profitDescendComparator implements Comparator<Program>{

        @Override
        public int compare(Program o1, Program o2) {
            return o2.profit - o1.profit;
        }
    }
    public static int maxMoney(int[] c,int[] p,int m ,int k){
        Program[] pm = new Program[c.length];
        for (int i = 0; i < c.length; i++) {
            pm[i] = new Program(c[i],p[i]);
        }
        // 按价格从低到高
        PriorityQueue<Program> costPQ = new PriorityQueue<>(new costAscendComparetor());
        for (Program program : pm) {
            costPQ.add(program);
        }
        PriorityQueue<Program> profitPQ = new PriorityQueue<>(new profitDescendComparator());
        int n = 0;
        while(n < k){
            while(!costPQ.isEmpty() && costPQ.peek().cost < m){
                profitPQ.add(costPQ.poll());
            }
            if(profitPQ.isEmpty()){
                return m;
            }
            m += profitPQ.poll().profit;
        }
        return m;
    }

    public static void main(String[] args) {
        int[] costs = new int[]{10, 15, 17, 30};
        int[] profits = new int[]{3, 2, 7, 10};
        int m = 13;
        int k = 3;
        System.out.println("可得到最大的收益为："+maxMoney(costs,profits,m,k));

        System.out.println("============================================");
        int k1 = 4;
        System.out.println("可得到最大的收益为："+maxMoney(costs,profits,m,k1));


    }
}
