package q695.v3;

/**
 * @author zhangnan
 * @date 2021/4/22 9:49
 */
public class Solution {

    private static final int[] directions = {-1, 0, 1, 0, -1};

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    // 辅助函数
    private int dfs(int[][] grid, int r, int c) {
        if (grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        int x, y, area = 1;
        for (int i = 0; i != 4; i++) {
            x = r + directions[i];
            y = r + directions[i + 1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
                // 先判断 然后递归
                area += dfs(grid, x, y);
            }
        }
        return area;
    }
}
