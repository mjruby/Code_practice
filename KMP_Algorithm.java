package fanli.selfcode.kmp;

import java.util.Arrays;

// str1= "BBC ABCDAB ABCDABCDABDE"
// str2="ABCDABD"
public class KMP_Algorithm {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "BCDABD";
//        int[] D = cal_D(str2);
//        System.out.println(Arrays.toString(D));
        int index = kmp_Algorithm(str1, str2);
        System.out.println("KMP �㷨 -- ���صĵ�һ��ƥ���±�Ϊ��" + index);
        System.out.println();
        System.out.print("String �� -- �Դ��ķ�����");
        System.out.println(str1.indexOf(str2));  // String �Դ���Ѱ��ƥ�䴮�ķ���

    }

    // ����D����    D[i] : arr[0] ~ arr[i]index
    public static int[] cal_D(String str) {
        char[] arr = str.toCharArray();
        int len = arr.length;
        int[] D = new int[len];
        D[0] = 0;
        int i = 1;
        int j = 0;
        while (i < len) {
            if (arr[i] == arr[j]) {
                D[i++] = ++j;
            } else {
                if (j > 0) {
                    j = D[j - 1];  // ע�⣨���������ƥ�����������
                } else {
                    i++;
                }
            }
        }
        return D;
    }

    // ƥ��
    public static int kmp_Algorithm(String str1, String str2) {
        int[] d = cal_D(str2);
        int len1 = str1.length();
        int len2 = str2.length();
        int i = 0;
        int j = 0;
        while (i < len1) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
                if (j == len2) {
                    return i - j;
                }
            } else {
                if (j == 0) {
                    i = i + 1;
                } else {
                    j = d[j - 1];
                }
            }
        }
        return -1;

    }
}
