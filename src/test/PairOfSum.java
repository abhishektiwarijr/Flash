package test;

import java.util.HashMap;
import java.util.Map;

public class PairOfSum {
    public static void main(String[] args) {
        int[] nums = new int[]{8, 7, 2, 5, 3, 1};
        System.out.println(findTargetSumPair(nums, 11));
    }

    private static String findTargetSumPair(int[] nums, int target) {
        Map<Integer, Integer> lookUp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer complementIndex = lookUp.get(nums[i]);
            if (complementIndex != null) {
                return "(Pair Found)";
            }
            lookUp.put(target - nums[i], i);
        }
        return "Pair not found";
    }

}
