package q347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhangnan
 * @date 2021/2/23 13:54
 */
//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
//
//
//
// 示例 1:
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
//
//
// 示例 2:
//
// 输入: nums = [1], k = 1
//输出: [1]
//
//
//
// 提示：
//
//
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
// 你可以按任意顺序返回答案。
// 桶排序
//
// Related Topics 堆 哈希表
// 👍 647 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer, Integer> map = new HashMap<>();
        int max_count = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            max_count = Math.max(map.get(num), max_count);
        }

        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] buckets = new List[max_count + 1];
        for (int key : map.keySet()) {
            // 获取出现的次数作为下标
            int i = map.get(key);
            if (buckets[i] == null) {
                buckets[i] = new ArrayList<>();
            }
            buckets[i].add(key);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = max_count; i > 0 && ans.size() < k; i--) {
            if (buckets[i] == null) {
                continue;
            }

            for (Integer num : buckets[i]) {
                ans.add(num);
                if (ans.size() == k) {
                    break;
                }
            }
        }

        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }


    public static void main(String[] args) {
        int[] nums = {5, 3, 1, 1, 1, 3, 73, 1};
        int k = 2;
        new Solution().topKFrequent(nums, k);
    }
}


//leetcode submit region end(Prohibit modification and deletion)

