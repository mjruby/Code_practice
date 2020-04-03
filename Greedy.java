package fanli.selfcode.greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 如何选择最少的广播台，让所有的地区都可以接收到信号
public class Greedy {

    static HashSet<String> allAreas = new HashSet<>();
    static HashMap<String,HashSet<String>> map = new HashMap<>();
    static HashSet<String> selected = new HashSet<>();

    public static void main(String[] args) {
        addBroads();
        System.out.println("所有要覆盖的城市有：");
        System.out.println(allAreas);
        greedy();
        System.out.println("贪心结果为："+selected);
    }

    // 贪心
    public static void greedy( ){
        String maxKey = "K1";
        Set<String> keys = map.keySet();
        while(allAreas.size() > 0){
            for (String key : keys) {
                HashSet<String> places = map.get(key);
                places.retainAll(allAreas);  // 取places和allAreas的交集
                HashSet<String> tmp = map.get(maxKey);
                tmp.retainAll(allAreas);
                if(places.size() > tmp.size()){
                    maxKey = key;
                }
            }
            allAreas.removeAll(map.get(maxKey));
            selected.add(maxKey);
            maxKey = "K1";
        }

        
    }
    // 添加广播站
    public static void addBroads(){
        HashSet<String> place1 =  new HashSet<>();
        place1.addAll(List.of("北京", "上海", "天津"));

        HashSet<String> place2 =  new HashSet<>();
        place2.addAll(List.of("广州", "北京", "深圳"));

        HashSet<String> place3 =  new HashSet<>();
        place3.addAll(List.of("成都", "上海", "杭州"));

        HashSet<String> place4 =  new HashSet<>();
        place4.addAll(List.of("上海", "天津"));

        HashSet<String> place5 =  new HashSet<>();
        place5.addAll(List.of("杭州", "大连"));

        // 建立一个hashmap 存放所有的广播站信息
        map.put("K1",place1); allAreas.addAll(place1);
        map.put("K2",place2); allAreas.addAll(place2);
        map.put("K3",place3); allAreas.addAll(place3);
        map.put("K4",place4); allAreas.addAll(place4);
        map.put("K5",place5); allAreas.addAll(place5);
    }
}


