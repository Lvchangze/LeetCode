package Stack;

import java.util.*;

public class P20 {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '[')
                stack.push(']');
            else if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (stack.isEmpty() || c != stack.pop())//遇到了反括号
                return false;
        }
        return stack.isEmpty();
    }
}
