package primary.coursefive.selfcode;

import java.util.HashMap;
import java.util.Set;

// 设计RandomPool结构
//【题目】 设计一种结构，在该结构中有如下三个功能：
//        insert(key)：将某个key加入到该结构，做到不重复加入。
//        delete(key)：将原本在结构中的某个key移除。
//        getRandom()：等概率随机返回结构中的任何一个key。
//【要求】 Insert、delete 和 getRandom方法的时间复杂度都是O(1)
public class RandomPool {

    public static class Pool<K>{
        private HashMap<K,Integer> keyIndexMap;
        private HashMap<Integer,K> IndexKeyMap;
        private Integer size = 0;

        public Pool(){
            this.keyIndexMap = new HashMap<>();   // 让指针指向空间
            this.IndexKeyMap = new HashMap<>();
        }

        public void insert(K key){
            this.keyIndexMap.put(key,this.size);
            this.IndexKeyMap.put(this.size++,key);
        }

        public K getRandom(){
            int index = (int)(Math.random() * this.size);
            return this.IndexKeyMap.get(index);
        }

        public void delete(K key){
            int deleleIndex = this.keyIndexMap.get(key);
            int lastIndex = --size;
            this.keyIndexMap.put(this.IndexKeyMap.get(lastIndex),deleleIndex);
            this.IndexKeyMap.put(deleleIndex,this.IndexKeyMap.get(lastIndex));
            this.keyIndexMap.remove(key);
            this.IndexKeyMap.remove(lastIndex);

        }
    }

    public static void main(String[] args) {
        Pool<String> pool = new Pool<>();
        pool.insert("mei");
        pool.insert("zhi");
        pool.insert("cheng");
        System.out.println(pool.getRandom());
        System.out.println("删除操作执行前,pool中的元素有：");
        Set<String> s = pool.keyIndexMap.keySet();
        for (String s1 : s) {
            System.out.println(s1);
        }

        System.out.println("删除操作执行后,pool中的元素有：");
        pool.delete("zhi");
        Set<String> ss = pool.keyIndexMap.keySet();
        for (String s1 : ss) {
            System.out.println(s1);
        }

    }
}
