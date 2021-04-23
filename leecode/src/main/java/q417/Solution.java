package q417;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    int[] directions = {-1, 0, 1, 0, -1};


    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> ans = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        // 大西洋
        boolean[][] can_reach_a = new boolean[m][n];

        // 太平洋
        boolean[][] can_reach_p = new boolean[m][n];


        for (int i = 0; i < m; i++) {
            dfs(matrix, can_reach_a, i, 0);
            dfs(matrix, can_reach_p, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            dfs(matrix, can_reach_a, 0, i);
            dfs(matrix, can_reach_p, m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (can_reach_a[i][j] && can_reach_p[i][j]) {
                    List<Integer> result = new ArrayList<>();
                    result.add(i);
                    result.add(j);
                    ans.add(result);
                }
            }
        }
        return ans;
    }


    private void dfs(int[][] matrix, boolean[][] can_reach, int r, int c) {
        if (can_reach[r][c]) {
            return;
        }
        can_reach[r][c] = true;
        int x, y;


        for (int i = 0; i < 4; i++) {
            x = r + directions[i];
            y = c + directions[i + 1];

            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length
                    && matrix[r][c] <= matrix[x][y]) {
                dfs(matrix, can_reach, x, y);
            }
        }
    }
}
