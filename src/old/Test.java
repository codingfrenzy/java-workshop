import java.util.Arrays;

/**
 * Created by prasanthnair on 8/15/15.
 */
public class Test {

    private int x = 4;

    public static void main(String[] args) {
//        int[] a = new int[2];

        int[] a = {1,2,3,4,5};
        int[] b = a.clone();

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        a[1] = 0;
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

    }
}