package fanli.selfcode.greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// ���ѡ�����ٵĹ㲥̨�������еĵ��������Խ��յ��ź�
public class Greedy {

    static HashSet<String> allAreas = new HashSet<>();
    static HashMap<String,HashSet<String>> map = new HashMap<>();
    static HashSet<String> selected = new HashSet<>();

    public static void main(String[] args) {
        addBroads();
        System.out.println("����Ҫ���ǵĳ����У�");
        System.out.println(allAreas);
        greedy();
        System.out.println("̰�Ľ��Ϊ��"+selected);
    }

    // ̰��
    public static void greedy( ){
        String maxKey = "K1";
        Set<String> keys = map.keySet();
        while(allAreas.size() > 0){
            for (String key : keys) {
                HashSet<String> places = map.get(key);
                places.retainAll(allAreas);  // ȡplaces��allAreas�Ľ���
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
    // ��ӹ㲥վ
    public static void addBroads(){
        HashSet<String> place1 =  new HashSet<>();
        place1.addAll(List.of("����", "�Ϻ�", "���"));

        HashSet<String> place2 =  new HashSet<>();
        place2.addAll(List.of("����", "����", "����"));

        HashSet<String> place3 =  new HashSet<>();
        place3.addAll(List.of("�ɶ�", "�Ϻ�", "����"));

        HashSet<String> place4 =  new HashSet<>();
        place4.addAll(List.of("�Ϻ�", "���"));

        HashSet<String> place5 =  new HashSet<>();
        place5.addAll(List.of("����", "����"));

        // ����һ��hashmap ������еĹ㲥վ��Ϣ
        map.put("K1",place1); allAreas.addAll(place1);
        map.put("K2",place2); allAreas.addAll(place2);
        map.put("K3",place3); allAreas.addAll(place3);
        map.put("K4",place4); allAreas.addAll(place4);
        map.put("K5",place5); allAreas.addAll(place5);
    }
}


