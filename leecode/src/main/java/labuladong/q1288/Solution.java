package labuladong.q1288;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhangnan
 * @date 2021/10/8
 */
public class Solution {

    public int removeCoveredIntervals(int[][] intervals) {

        // 对数组进行排序 排序规则 按照起点升序排序 起点相同时降序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o2[1], o1[1]);
                } else {
                    return Integer.compare(o1[0], o2[0]);
                }
            }
        });

        int left = intervals[0][0];
        int right = intervals[0][1];

        int res = 0;

        for (int i = 1; i < intervals.length; i++) {
            int[] intv = intervals[i];

            // 第一种情况 找到覆盖区间
            if (left <= intv[0] && right >= intv[1]) {
                res++;
            }

            // 第二种情况 找到相交区间 合并区间
            if (right >= intv[0] && right <= intv[1]) {
                right = intv[1];
            }

            // 第三种情况完全不想交 更新起点和终点
            if (right < intv[0]) {
                left = intv[0];
                right = intv[1];
            }
        }

        return intervals.length - res;
    }
}
