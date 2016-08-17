/**
 * Created by prasanthnair on 6/30/15.
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        if (s.length() == 0 || s.length() % 2 != 0)
            return false;

        char c[] = s.toCharArray();
        char stack[] = new char[c.length];
        int top = 0;

        boolean breakLoop = false;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(' || c[i] == '{' || c[i] == '[') {
                stack[top] = c[i];
                top++;
            } else {
                if (i == 0)
                    return false;
                switch (c[i]) {
                    case ')':
                        if (stack[top - 1] == '(') {
                            top--;
                        } else {
                            breakLoop = true;
                        }
                        break;
                    case '}':
                        if (stack[top - 1] == '{') {
                            top--;
                        } else {
                            breakLoop = true;
                        }
                        break;
                    case ']':
                        if (stack[top - 1] == '[') {
                            top--;
                        } else {
                            breakLoop = true;
                        }
                        break;
                }
            }
            if (breakLoop)
                break;
        }

        if (top == 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(ValidParentheses.isValid("()[]{}"));
    }
}
