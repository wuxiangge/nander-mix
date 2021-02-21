package q69;

/**
 * @author zhangnan
 * @date 2021/2/21 15:29
 */
//实现 int sqrt(int x) 函数。
//
// 计算并返回 x 的平方根，其中 x 是非负整数。
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
//
// 示例 1:
//
// 输入: 4
//输出: 2
//
//
// 示例 2:
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842...,
//     由于返回类型是整数，小数部分将被舍去。
//
// Related Topics 数学 二分查找
// 👍 597 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {

        if (x == 0) {
            return x;
        }

        int l = 1;
        int r = x;
        int mid = 0;
        int sqrt = 0;

        while (l <= r) {
            mid = l + (r - l) / 2;
            sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (mid > sqrt) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

