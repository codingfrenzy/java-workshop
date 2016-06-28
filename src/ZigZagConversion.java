/**
 * Created by prasanthnair on 6/25/15.
 */
public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        int set = numRows + (numRows - 2);
        int colPerSet = 1 + (numRows - 2);
        int columns = ((s.length() / set) + 1) * colPerSet;

        int r = 0, c = 0;
        char[][] op = new char[numRows][columns];
        boolean down = true, first = true;
        for (int i = 0; i < s.length(); i++) {
            op[r][c] = s.charAt(i);

            if ((r == 0 || r == numRows - 1) && !first)
                down = !down;

            if (down) {
                r++;
            } else {
                r--;
                c++;
            }

            first = false;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < columns; j++) {
                sb.append(op[i][j]);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(ZigZagConversion.convert("A", 2));
    }
}
