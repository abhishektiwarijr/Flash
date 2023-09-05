package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
//        System.out.println(Arrays.toString(twoSum(nums, 9))); //0,1
        System.out.println(Arrays.toString(twoSumFast(nums, 9))); //0,1
    }

    private static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return nums;
    }

    private static int[] twoSumFast(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer complementIndex = map.get(nums[i]);
            if (complementIndex != null) {
                return new int[]{complementIndex, i};
            }
            map.put(target - nums[i], i);
        }
        return nums;
    }
}
