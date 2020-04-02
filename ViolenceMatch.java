package fanli.selfcode.kmp;
// str1= "BBC ABCDAB ABCDABCDABDE"
// str2="ABCDABD"
public class ViolenceMatch {
    public static void main(String[] args) {
//        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str1 = "B ABCDABCDABDE";
        String str2 = "ABCDABD";
        System.out.println("dd"+str2.charAt(0)+str2.charAt(1));
//        String str2 = "DAB";
        System.out.println("匹配结果为："+match(str1,str2));
    }

    public static int match(String str1,String str2){
        int i =0;
        int j=0;
        while(i<str1.length()&&j<str2.length()){
            if(str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
            }else{
                i = i-j+1;  // 这两个的先后顺序会导致出错
                j = 0;
            }
        }
        if(j == str2.length()){
            return (i -j);
        }else {
            return -1;
        }
    }
}
