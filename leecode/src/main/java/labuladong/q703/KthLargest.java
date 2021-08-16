package labuladong.q703;

//设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
//
// 请实现 KthLargest 类：
//
//
// KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
// int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
//
//
//
//
// 示例：
//
//
//输入：
//["KthLargest", "add", "add", "add", "add", "add"]
//[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
//输出：
//[null, 4, 5, 5, 8, 8]
//
//解释：
//KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
//kthLargest.add(3);   // return 4
//kthLargest.add(5);   // return 5
//kthLargest.add(10);  // return 5
//kthLargest.add(9);   // return 8
//kthLargest.add(4);   // return 8
//
//
//
//提示：
//
//
// 1 <= k <= 104
// 0 <= nums.length <= 104
// -104 <= nums[i] <= 104
// -104 <= val <= 104
// 最多调用 add 方法 104 次
// 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素
//
// Related Topics 树 设计 二叉搜索树 二叉树 数据流 堆（优先队列）
// 👍 283 👎 0

import java.util.PriorityQueue;

public class KthLargest {

    private PriorityQueue<Integer> pq;
    private Integer global_k;

    public KthLargest(int k, int[] nums) {
        this.global_k = k;
        pq = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }

    }

    public int add(int val) {
        pq.offer(val);
        while (pq.size() > global_k) {
            pq.poll();
        }
        return pq.peek();
    }

}
