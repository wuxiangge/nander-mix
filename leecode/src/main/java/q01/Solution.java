package q01;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] minusArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            minusArr[i] = target - nums[i];
        }

        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < minusArr.length; j++) {
                if (nums[i] == minusArr[j]) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
