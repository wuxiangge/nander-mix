package q52;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangnan
 * @date 2021-04-29 22:56
 */
public class Solution {
    public int totalNQueens(int n) {
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> leftDiagonals = new HashSet<Integer>();
        Set<Integer> rightDiagonals = new HashSet<Integer>();
        return backtrack(n, 0, columns, leftDiagonals, rightDiagonals);
    }

    public int backtrack(int n, int row, Set<Integer> columns, Set<Integer> leftDiagonals, Set<Integer> rightDiagonals) {
        if (row == n) {
            return 1;
        } else {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int leftDiagonal = row - i;
                if (leftDiagonals.contains(leftDiagonal)) {
                    continue;
                }
                int rightDiagonal = row + i;
                if (rightDiagonals.contains(rightDiagonal)) {
                    continue;
                }
                columns.add(i);
                leftDiagonals.add(leftDiagonal);
                rightDiagonals.add(rightDiagonal);
                count += backtrack(n, row + 1, columns, leftDiagonals, rightDiagonals);
                columns.remove(i);
                leftDiagonals.remove(leftDiagonal);
                rightDiagonals.remove(rightDiagonal);
            }
            return count;
        }
    }
}

