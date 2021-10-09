package labuladong.q134;

/**
 * @author zhangnan
 * @date 2021/10/9
 */
//在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
//
// 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
//
// 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
//
// 说明:
//
//
// 如果题目有解，该答案即为唯一答案。
// 输入数组均为非空数组，且长度相同。
// 输入数组中的元素均为非负数。
//
//
// 示例 1:
//
// 输入:
//gas  = [1,2,3,4,5]
//cost = [3,4,5,1,2]
//
//输出: 3
//
//解释:
//从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
//开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
//开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
//开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
//开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
//开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
//因此，3 可为起始索引。
//
// 示例 2:
//
// 输入:
//gas  = [2,3,4]
//cost = [3,4,3]
//
//输出: -1
//
//解释:
//你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
//我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
//开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
//开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
//你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
//因此，无论怎样，你都不可能绕环路行驶一周。
// Related Topics 贪心 数组
// 👍 749 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;
        int tank = 0;

        for (int start = 0; start < n; start++) {
            loopFlag:
            for (int step = 0; step < n; step++) {
                int i = (start + step) % n;
                tank += gas[i];
                tank -= cost[i];

                // 判断油是否耗尽
                if (tank < 0) {
                    tank = 0;  // 重置
                    break loopFlag;
                }

                // 成功走了一圈
                if (step == n - 1) {
                    return start;
                }
            }
        }
        return -1;
    }


    /**
     * 将问题抽象成一个环形数组 问能否找到一个起点 使得走完整个环形数组
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;

        int sum = 0;
        int minSum = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            if (sum < minSum) {

                // 经过第 i 个站点后，使 sum 到达新低
                // 所以站点 i + 1 就是最低点（起点）

                start = i + 1;
                minSum = sum;
            }
        }

        if (sum < 0) {
            return -1;
        }
        return start == n ? 0 : start;
    }


    public int canCompleteCircuit3(int[] gas, int[] cost) {


        int n = gas.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
        }

        if (sum < 0) {
            return -1;
        }


        int tank = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                // 无法从start走到i
                tank = 0;
                start = i + 1;
            }
        }

        return start == n ? 0 : start;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});

    }
}
//leetcode submit region end(Prohibit modification and deletion)
