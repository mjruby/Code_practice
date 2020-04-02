package fanli.selfcode.dynamic;

import java.util.Arrays;

// ��̬�滮�㷨���ʵ��-��������
// w -- 1 4 3
// value -- 1500 3000 2000
public class KnapsackProblem {

    public static void main(String[] args) {
        int[] w = new int[]{1, 4, 3};
        int[] value = new int[]{1500, 3000, 2000};
        int[] tmp = Arrays.copyOf(w, w.length);
        Arrays.sort(tmp);
//        System.out.println(Arrays.toString(tmp));
        int[][] v = new int[value.length + 1][tmp[tmp.length - 1] + 1];
        int[][] path = new int[v.length][v[0].length];
        int max = knapsackProblem(w, value, v, path);
        printMatrix(v);
        System.out.println();
        System.out.println("��0-1����������Ϊ��" + max);
        System.out.println("======================================");
        printPath(path, w);
    }

    public static int knapsackProblem(int[] w, int[] value, int[][] v, int[][] path) {
        // ��0�к͵�0�и�ֵΪ0
        for (int i = 0; i < v[0].length; i++) v[0][i] = 0;
        for (int i = 0; i < v.length; i++) v[i][0] = 0;

        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (w[i - 1] <= j) {  // �±�Ϊ i-1 �Ŀ��Կ����Ƿ������
                    v[i][j] = Math.max(v[i - 1][j], (value[i - 1] + v[i - 1][j - w[i - 1]]));
                    path[i][j] = 1;
                } else {
                    v[i][j] = v[i - 1][j];
                }

            }
        }
        return v[v.length - 1][v[0].length - 1];
    }

    public static void printPath(int[][] path, int[] w) {
        System.out.println();
        System.out.println("Path �����Ϊ");
        printMatrix(path);
        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.println("����" + i + "����Ʒ����");
                j = j - w[i - 1];
                i--;
            }
            i--;
        }

    }

    public static void printMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
}
