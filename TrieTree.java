package primary.courseseven.self;

public class TrieTree {
    public static class TrieTreeNode{
        int path;
        int end;
        TrieTreeNode[] nexts;

        public TrieTreeNode(){
            this.path = 0;
            this.end = 0;
            nexts = new TrieTreeNode[26];  // 可存储26个小写英文字母
        }
    }

    public static class Trie{
        private TrieTreeNode root;

        public Trie(){
            this.root = new TrieTreeNode();
        }

        public void insert(String str){
            if(str == null) return;
            char[] arr = str.toCharArray();
            int index = 0;
            TrieTreeNode node = root;
            for (int i = 0; i < arr.length; i++) {
                index = arr[i] - 'a';
                if(node.nexts[index] == null){
                    node.nexts[index] = new TrieTreeNode();
                    node = node.nexts[index];
                    node.path++;
                }else {
                    node = node.nexts[index];
                    node.path++;
                }
            }
            node.end++;
        }

        public int search(String str){ // 查找str字符串出现的次数
            if(str == null) return 0;
            char[] arr = str.toCharArray();
            int index = 0;
            TrieTreeNode node = root;
            for (int i = 0; i < arr.length; i++) {
                index = arr[i] - 'a';
                if(node.nexts[index] == null){
                    return 0;
                }else {
                    node = node.nexts[index];
                }
            }
            return node.end;
        }

        public void delete(String str){ // 删除字符串str
            if(this.search(str) == 0) return;
            char[] arr = str.toCharArray();
            int index = 0;
            TrieTreeNode node = root;
            for (int i = 0; i < arr.length; i++) {
                index = arr[i] - 'a';
                if(--node.nexts[index].path == 0){
                    node.nexts[index] = null;
                    break;  // 结束循环体
                }else {
                    node = node.nexts[index];
                }
            }
            node.end--;
        }

        public int prefixNumber(String str) { // 返回以 str 为前缀的字符串个数
            if(str == null) return 0;
            char[] arr = str.toCharArray();
            int index = 0;
            TrieTreeNode node = root;
            for (int i = 0; i < arr.length; i++) {
                index = arr[i] - 'a';
                if(node.nexts[index] != null){
                    node = node.nexts[index];
                }else {
                    return 0;
                }
            }
            return node.path;
        }
    }

    public static void main(String[] args) {
        Trie tTree = new Trie();
        tTree.insert("abc");
        tTree.insert("cdf");
        System.out.println("字符串出现的次数是："+tTree.search("abc")); // 1
        System.out.println("字符串出现的次数是："+tTree.search("a")); // 0
        System.out.println("字符串出现的次数是："+tTree.search("cdf")); // 1
        tTree.delete("cdf");
        System.out.println("字符串出现的次数是："+tTree.search("cdf")); // 0
        tTree.insert("abc");
        System.out.println("字符串出现的次数是："+tTree.search("abc")); // 2
        tTree.delete("b");
        tTree.insert("abcde");
        System.out.println("以abc开头的字符串的个数为"+tTree.prefixNumber("abc")); // 3
    }
}
