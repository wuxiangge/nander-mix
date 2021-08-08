package labuladong.q173;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangnan
 * @className Solution
 * @date 2021/8/7
 * @description //TODO
 */
public class BSTIterator2 {

    private TreeNode cur;
    private Deque<TreeNode> stack;

    public BSTIterator2(TreeNode root) {
        this.cur = root;
        this.stack = new LinkedList<>();
    }

    public int next() {
        while (cur != null) {
            stack.push(cur.left);
            cur = cur.left;
        }
        cur = stack.pop();
        int ret = cur.val;
        cur = cur.right;
        return ret;
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }

}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */