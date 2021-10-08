package labuladong.q435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhangnan
 * @date 2021/10/8
 */
public class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        // [ [1,2],
        //   [2,3],
        //   [3,4],
        //   [1,3]
        // ]  int[4][2]


        // base 如果数组的长度小于等于1直接返回
        if (intervals.length <= 1) {
            return 0;
        }


        // 对数组进行排序 按照end升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[2];
            }
        });


        int length = intervals.length;

        int total = 0;

        int prev = intervals[0][1];

        for (int i = 1; i < length; ++i) {
            if (intervals[i][0] < prev) {
                ++total;
            } else {
                prev = intervals[i][1];
            }
        }

        return total;
    }
}
