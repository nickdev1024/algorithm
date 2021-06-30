package TopInterview;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Q020ValidParentheses {

    private final Map<Character, Character> map;

    {
        map = new HashMap<>();
        char[] keys = {')', '}', ']'};
        char[] values = {'(', '{', '['};
        int len = keys.length;
        for (int i = 0; i < len; i++) {
            map.put(keys[i], values[i]);
        }
    }

    private boolean isValid(String s) {
        if (null == s || s.length() == 1) {
            return false;
        }
        char[] str = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : str) {
            if (!map.containsKey(c) && !map.containsValue(c)) {
                return false;
            }
            if (map.containsKey(c)) {
                if (stack.empty()) {
                    return false;
                }
                if (stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }

    static public void main(String... args) {
        String[] data = {"()", "()[]{}", "(]", "([)]", "{[]}"};
        Q020ValidParentheses obj = new Q020ValidParentheses();
        for (String str : data) {
            System.out.println(str + ": " + obj.isValid(str));
        }
    }
}