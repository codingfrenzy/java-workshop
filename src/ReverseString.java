/**
 * https://leetcode.com/problems/reverse-string/
 * <p>
 * Write a function that takes a string as input and returns the string reversed.
 * <p>
 * Example:
 * Given s = "hello", return "olleh".
 */

public class ReverseString extends ASolution {
    @Override
    public void runSolution() {
        println(reverseString("hello"));
    }

    public String reverseString(String s) {
        char[] cs = new char[s.length()];
        for (int i = cs.length - 1; i >= 0; i--) {
            cs[i] = s.charAt(cs.length - 1 - i);
        }
        return String.valueOf(cs);
    }
}
