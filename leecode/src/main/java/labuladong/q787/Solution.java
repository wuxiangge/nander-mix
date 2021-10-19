package labuladong.q787;

//有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城
//市 fromi 开始，以价格 pricei 抵达 toi。
//
// 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便
//宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
//
//
//
// 示例 1：
//
//
//输入:
//n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//src = 0, dst = 2, k = 1
//输出: 200
//解释:
//城市航班图如下
//
//
//从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。
//
// 示例 2：
//
//
//输入:
//n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//src = 0, dst = 2, k = 0
//输出: 500
//解释:
//城市航班图如下
//
//
//从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。
//
//
//
// 提示：
//
//
// 1 <= n <= 100
// 0 <= flights.length <= (n * (n - 1) / 2)
// flights[i].length == 3
// 0 <= fromi, toi < n
// fromi != toi
// 1 <= pricei <= 104
// 航班没有重复，且不存在自环
// 0 <= src, dst, k < n
// src != dst
//
// Related Topics 深度优先搜索 广度优先搜索 图 动态规划 最短路 堆（优先队列）
// 👍 406 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 加权有向图中求最短路径问题
    // 求最短路径问题
    // bfs广度优先搜索 使用普通Queue来遍历多叉树
    // 加权图的最多路径 使用优先队列PriorityQueue


    Map<Integer, List<int[]>> indegree;
    int src, dst;
    int[][] memo;


    // 动态规划写法 自定向下
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 将中转站个数转化成条数
        k++;
        this.src = src;
        this.dst = dst;
        memo = new int[n][k + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -888);
        }

        indegree = new HashMap<>();
        for (int[] f : flights) {
            int from = f[0];
            int to = f[1];
            int price = f[2];

            indegree.putIfAbsent(to, new ArrayList<>());
            indegree.get(to).add(new int[]{from, price});
        }
        return dp(dst, k);
    }


    private int dp(int dst, int k) {
        if (dst == src) {
            return 0;
        }

        if (k == 0) {
            return -1;
        }

        if (memo[dst][k] != -888) {
            return memo[dst][k];
        }


        int res = Integer.MAX_VALUE;
        if (indegree.containsKey(dst)) {
            // 当dst有入度时，分解为子问题
            for (int[] v : indegree.get(dst)) {
                int from = v[0];
                int price = v[1];

                int subProblem = dp(from, k - 1);
                if (subProblem != -1) {
                    res = Math.min(res, subProblem + price);
                }
            }
        }
        // 如果还是初始值，说明次节点不可达
        memo[dst][k] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[dst][k];
    }


    // 优先队列 + 广度优先搜索
    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        for (int[] f : flights) {
            if (!prices.containsKey(f[0])) {
                prices.put(f[0], new HashMap<>());
            }
            prices.get(f[0]).put(f[1], f[2]);
        }
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
        pq.add(new int[]{0, src, k + 1});
        while (!pq.isEmpty()) {
            int[] top = pq.remove();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if (city == dst) {
                return price;
            }
            if (stops > 0) {
                Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());
                for (int a : adj.keySet()) {
                    pq.add(new int[]{price + adj.get(a), a, stops - 1});
                }
            }
        }
        return -1;
    }

    // 回溯算法+深度优先搜索+剪枝函数


}
