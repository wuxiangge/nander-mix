package labuladong.q173;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangnan
 * @className Solution
 * @date 2021/8/7
 * @description //TODO
 */
public class BSTIterator {

    private int index;
    private List<Integer> array;

    public BSTIterator(TreeNode root) {
        this.index = 0;
        array = new ArrayList<>();
        inOrder(root);
    }

    public int next() {
        return array.get(index++);
    }

    public boolean hasNext() {
        return index < array.size();
    }


    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        array.add(node.val);
        inOrder(node.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */