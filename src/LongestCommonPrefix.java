/**
 * Created by prasanthnair on 6/27/15.
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1)
            return strs[0];
        else if (strs == null || strs.length == 0)
            return "";

        StringBuilder common = new StringBuilder();

        for (int chars = 0; chars < strs[0].length(); chars++) {
            boolean stop = false;
            char c = strs[0].charAt(chars);
            common.append(c);
            for (int str = 0; str < strs.length; str++) {
                if (chars >= strs[str].length() || strs[str].charAt(chars) != c) {
                    common.setLength(chars);
                    stop = true;
                }
            }
            if (stop)
                break;
        }
        return common.toString();

    }

    public static void main(String[] args) {
        String[] a = {
                "ABC",
                "A",
                "A",
                ""
        };
        System.out.println(LongestCommonPrefix.longestCommonPrefix(a));
    }
}
