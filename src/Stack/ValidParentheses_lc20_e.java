package Stack;

import java.util.Stack;

public class ValidParentheses_lc20_e {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                Character cc = stack.pop();
                if (cc != '(' && c == ')') {
                    return false;
                } else if (cc != '[' && c == ']') {
                    return false;
                } else if (cc != '{' && c == '}') {
                    return false;
                }
            }
        }
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses_lc20_e().isValid("{}["));
        System.out.println(new ValidParentheses_lc20_e().isValid("{}"));
    }
}
