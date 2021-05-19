package q1288;

import java.util.Arrays;

/**
 * @author zhangnan
 * @date 2021/5/19 14:05
 */
public class Solution {


    /**
     * 情况1
     * ---------------------
     * ---------
     * 情况2
     * ------------
     * ----------------
     * 情况3
     * --------------
     * -----------------------
     *
     * @param intervals
     * @return
     */


    public int removeCoveredIntervals(int[][] intervals) {
        // 起点按照升序排序 起点相同的降序排序
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int left = intervals[0][0];
        int right = intervals[0][1];
        int result = 0;

        for (int i = 1; i < intervals.length; i++) {
            int[] intv = intervals[i];
            // 找到覆盖区间
            if (left <= intv[0] && right >= intv[1]) {
                result++;
            }

            // 找到相交区间 合并
            if (right >= intv[0] && right <= intv[1]) {
                right = intv[1];
            }

            // 情况三，完全不相交，更新起点和终点
            if (right < intv[0]) {
                left = intv[0];
                right = intv[1];
            }
        }
        return intervals.length - result;
    }

}
