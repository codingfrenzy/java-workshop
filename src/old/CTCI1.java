import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by prasanthnair on 8/16/15.
 */

class CTCI1 {

    public static String c14_compress(String str) {
        if (str.length() <= 1)
            return str;

        StringBuffer sb = new StringBuffer();
        int count = 1;
        char[] c = str.toCharArray();
        char current = c[0];
        for (int i = 1; i < c.length; i++) {
            if (current == c[i])
                count++;
            else {
                sb.append(current);
                sb.append(count);
                current = c[i];
                count = 1;
            }
        }

        sb.append(current);
        sb.append(count);

        if (sb.length() >= str.length())
            return str;
        else
            return sb.toString();
    }

    public static void c15_space(String str, int len) {
        if (len == 0)
            return;

        char[] c = str.toCharArray();
        int i = 0, count = 0;
        boolean dir_right = true;

        while (true) {
            if (i == -1)
                break;

            if (dir_right) {
                if (c[i] == ' ')
                    count++;
                i++;
            }

            if (dir_right && i == len) {
                dir_right = !dir_right;
                i--;
            }

            if (!dir_right) {
                int temp = (count * 2) + i;
                if (c[i] == ' ') {
                    c[temp] = '0';
                    c[temp - 1] = '2';
                    c[temp - 2] = '%';
                    count--;
                } else {
                    c[temp] = c[i];
                }
                i--;
            }

        }

        System.out.println(Arrays.toString(c));
    }

    public static void c16_rotateAll(int[][] a, int i, int j) {
        int N = a.length - 1;
        int temp = a[j][N - i];
        a[j][N - i] = a[i][j];
        int temp2 = a[N - i][N - j];
        a[N - i][N - j] = temp;
        temp = a[N - j][N - (N - i)];
        a[N - j][N - (N - i)] = temp2;
        a[i][j] = temp;
    }

    public static void c16_rotate(int[][] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if ((n % 2 != 0) && i == (n - 1) / 2 && i == j)
                    return;

                if (j == n - 1 - i)
                    break;

                CTCI1.c16_rotateAll(a, i, j);

                if ((n % 2 == 0) && i == (n - 1) / 2 && i == j)
                    return;

            }
        }
    }

    public static void arr_init() {
        int[][] arr = {
                {1, 2, 3, 4, 5, 6},
                {6, 7, 8, 9, 10, 0},
                {11, 0, 13, 14, 15, 2},
//                {16, 17, 18, 19, 20, 21},
                {21, 22, 23, 24, 25, 26},
//                {27, 28, 29, 30, 31, 32}
        };

        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.format("%3d", arr[i][j]);
            }
            System.out.print("\n");
        }

        c17_zero(arr);

        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.format("%3d", arr[i][j]);
            }
            System.out.print("\n");
        }
    }

    public static void c17_zero(int[][] a) {

        HashSet<Integer> rowSet = new HashSet<Integer>();
        HashSet<Integer> colSet = new HashSet<Integer>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (rowSet.contains(i) || colSet.contains(j))
                    continue;

                if (a[i][j] == 0) {
                    //change col
                    for (int k = 0; k < a.length; k++)
                        a[k][j] = 0;
                    for (int k = 0; k < a[0].length; k++)
                        a[i][k] = 0;
                    rowSet.add(i);
                    colSet.add(j);
                }

            }
        }
    }

    public static void main(String[] args) {
//        CTCI1.c15_space("Mr John Smith    ", 13);
//        System.out.println(CTCI1.c14_compress("aabb"));

        CTCI1.arr_init();

    }
}
