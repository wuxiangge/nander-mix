package q965.v2;


import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    private class Node {

        public int i;

        public int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }

    }

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] directions = {-1, 0, 1, 0, -1};

        int local_area = 0;
        int area = 0;


        for (int i = 0; i != m; i++) {

            for (int j = 0; j != n; j++) {
                if (grid[i][j] == 1) {
                    local_area = 1;
                    grid[i][j] = 0;
                    Deque<Node> stack = new ArrayDeque<>();
                    stack.push(new Node(i, j));

                    while (!stack.isEmpty()) {
                        Node pop = stack.pop();

                        for (int k = 0; k != 4; k++) {
                            int x = pop.i + directions[k];
                            int y = pop.j + directions[k + 1];

                            if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1) {
                                grid[x][y] = 0;
                                ++local_area;
                                stack.push(new Node(x, y));
                            }
                        }
                    }
                    area = Math.max(area, local_area);
                }
            }
        }
        return area;
    }
}
