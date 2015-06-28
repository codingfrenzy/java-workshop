import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by prasanthnair on 6/27/15.
 */
public class RomanToInteger {
    public int romanToInt(String s) {

        if (s.isEmpty() || s == null)
            return 0;

        s = s.toUpperCase();
        char[] c = s.toCharArray();
        int number = 0;
        int prev = 0;

        for (int i = c.length - 1; i >= 0; i--) {
            int current = value(c[i]);

            if (current < prev) {
                number -= current;
            } else {
                number += current;
            }
            prev = current;
        }

        return number;

    }

    public static int value(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }


    public static void main(String[] args) {
//        System.out.println(RomanToInteger.romanToInt("DCXXI"));
    }
}
