package primary.coursefive.selfcode;

import java.util.*;
import java.util.Map.Entry;

public class HashMap_test {

    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new  HashMap <Integer, Integer>();
        map.put(1,4);
        map.put(2,4);
        map.put(3,5);
        map.put(6,4);
        map.put(5,8);

        Set<Entry<Integer, Integer>> entries = map.entrySet();
        for (Entry<Integer, Integer> entry : entries) {
            int key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + " --> " + value);
        }

        Set<Integer> removekey = new HashSet<>();
        for (Entry<Integer, Integer> entry : entries) {
            if(entry.getValue() == 4){
                removekey.add(entry.getKey());
            }
        }

        for (Integer key : removekey) {
            map.remove(key);
        }

        System.out.println("删除值为4的hash表为：");
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            System.out.println(key +" --> " +map.get(key));
        }
    }

}
