package labuladong.q255;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhangnan
 * @className Solution
 * @date 2021/8/8
 * @description //TODO
 */
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Deque<Integer> stack = new LinkedList<>();
        Integer preElement = Integer.MIN_VALUE;

        for (int i = 0; i < preorder.length; i++) {
            if (preorder[i] < preElement) {
                return false;
            }

            while (!stack.isEmpty() && preorder[i] > stack.peek()) {
                preElement = stack.pop();
            }
            stack.push(preorder[i]);
        }
        return true;
    }

}
