package q695.v2;


import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    private static final int[] DIRECTIONS = {-1, 0, 1, 0, -1};

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int local_area = 0;
        int area = 0;

        for (int i = 0; i != m; i++) {
            for (int j = 0; j != n; j++) {
                if (grid[i][j] == 1) {
                    local_area = 1;
                    grid[i][j] = 0;
                    Deque<Pair<Integer, Integer>> stack = new ArrayDeque<>();
                    stack.push(new Pair<>(i, j));
                    while (!stack.isEmpty()) {
                        Pair<Integer, Integer> pop = stack.pop();
                        for (int k = 0; k != 4; k++) {
                            int x = pop.first + DIRECTIONS[k];
                            int y = pop.second + DIRECTIONS[k + 1];
                            if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1) {
                                grid[x][y] = 0;
                                ++local_area;
                                stack.push(new Pair<>(x, y));
                            }
                        }
                    }
                    area = Math.max(area, local_area);
                }
            }
        }
        return area;
    }


    private static class Pair<K, V> {
        public K first;
        public V second;

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }

        public Pair() {
            this(null, null);
        }
    }
}
