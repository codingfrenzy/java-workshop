/**
 * Created by prasanthnair on 6/24/15.
 */
public class ReverseInteger {
    public static int reverse(int x) {

        if (x == 0)
            return 0;

        if (x == Integer.MIN_VALUE || x == Integer.MAX_VALUE)
            return 0;

        boolean neg;
        int temp;
        if (x < 0) {
            temp = x * -1;
            neg = true;
        } else {
            temp = x;
            neg = false;
        }

        int length = (int) (Math.log10(temp) + 1);
        int rev = 0;
        long temp1;

        for (int i = length - 1; i >= 0; i--) {
            temp1 = (temp % 10) * (long) Math.pow(10, i);
            if (rev + temp1 > Integer.MAX_VALUE) {
                return 0;
            }
            rev = (int) temp1 + rev;
            temp = temp / 10;
            System.out.println(temp);
            System.out.println(temp1);
            System.out.println(rev);
        }

        if (neg)
            rev = rev * -1;

        return rev;
    }

    public static void main(String[] args) {
        System.out.println(ReverseInteger.reverse(1563847412));

//        StringBuilder sb = new StringBuilder("1563847412");
        System.out.println(Integer.MAX_VALUE);
    }
}
