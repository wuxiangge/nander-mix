package q20.v2;

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

        Stack<Character> stack = new Stack();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
