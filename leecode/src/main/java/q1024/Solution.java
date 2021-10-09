package q1024;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhangnan
 * @date 2021/10/8
 */
public class Solution {

    public int videoStitching(int[][] clips, int time) {

        if (time == 0) {
            return 0;
        }

        // 按照起点升序排序 起点相同按照降序排序
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    // 值相同倒叙排序
                    return Integer.compare(o2[1], o1[1]);
                } else {
                    // 值不相同正序排序
                    return Integer.compare(o1[0], o2[0]);
                }
            }
        });


        int res = 0;

        int i = 0;
        int n = clips.length;
        int curEnd = 0;
        int nextEnd = 0;

        while (i < n && clips[i][0] <= curEnd) {
            // 在第res个视频的区间内贪心选择下一个视频
            while (i < n && clips[i][0] <= curEnd) {
                nextEnd = Math.max(nextEnd, clips[i][1]);
                i++;
            }

            res++;
            curEnd = nextEnd;
            if (curEnd >= time) {
                // 已经可以拼接出【0,T】
                return res;
            }
        }

        return -1;
    }


    //
    //
    //
    //


}
