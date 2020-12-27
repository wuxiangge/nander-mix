package q20.v1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zhangnan
 * @date 2020-11-15 20:34
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');

            }
        };

        Stack<Character> stack = new Stack();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (pairs.containsKey(c)) {
                if (stack.isEmpty() || !stack.peek().equals(pairs.get(c))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);

            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
