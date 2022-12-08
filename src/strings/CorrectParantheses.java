package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class CorrectParantheses {

    public static void main(String[] args) {
        System.out.println(isValid("(("));
        System.out.println(isValid("){"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
    }

    public static boolean isValid(String s) {
        if (s.length() <= 1) {
            return false;
        }

        List<Character> characters = new ArrayList<>();
        characters.add('(');
        characters.add('[');
        characters.add('{');

        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        char[] arr = s.toCharArray();

        for (char c : arr) {
            if (characters.contains(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (stack.peek().equals(map.get(c)))
                    {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }

    public static boolean isValidSimplified(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
