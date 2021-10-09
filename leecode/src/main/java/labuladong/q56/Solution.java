package labuladong.q56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhangnan
 * @date 2021/10/8
 */
public class Solution {

    //合并区间
    public int[][] merge(int[][] intervals) {

        // 按照起点升序排序 起点相同则降序排序
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


        // 开始定义区间
        int left = intervals[0][0];
        int right = intervals[0][1];


        List<int[]> result = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {

            int[] intv = intervals[i];

            //  =============
            //          =========
            //                      ==========
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

}
