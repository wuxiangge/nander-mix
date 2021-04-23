package q547;

import java.util.Arrays;

/**
 * 深度优先搜索
 * 并查集
 */
public class Solution {

    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[m];
        Arrays.fill(visited, false);
        for (int i = 0; i < m; i++) {
            if (!visited[i]) {
                dfs(isConnected, i, visited);
                ++count;
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, int i, boolean[] visited) {
        visited[i] = true;
        for (int k = 0; k < isConnected.length; k++) {
            if (isConnected[i][k] == 1 && !visited[k]) {
                dfs(isConnected, k, visited);
            }
        }
    }


}
