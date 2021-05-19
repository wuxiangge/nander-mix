package q56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangnan
 * @date 2021/5/19 15:48
 */

//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
//
//
//
// 示例 1：
//
//
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2：
//
//
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
//
//
// 提示：
//
//
// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104
//
// Related Topics 排序 数组
// 👍 930 👎 0


/**
 * ---------
 * <p>
 * <p>
 * --------
 * ------------
 * -------------
 * ------------------------
 * ----------
 */


public class Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });


        int left = intervals[0][0];
        int right = intervals[0][1];
        List<int[]> result = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {

            int[] intv = intervals[i];
/**
 *
 *
 *
 *
 * ---
 * -----
 *
 *  -
 *   -------
 *
 *
 *                  -------
 */


            // 合并区间
            if (intv[0] >= left && intv[0] <= right && intv[1] >= right) {
                right = intv[1];
            }

            if (intv[0] > right) {
                result.add(new int[]{left, right});
                left = intv[0];
                right = intv[1];
            }
        }

        result.add(new int[]{left, right});
        return result.toArray(new int[result.size()][]);

    }


    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        Solution solution = new Solution();
        solution.merge(intervals);
    }

}
