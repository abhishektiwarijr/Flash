package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairsJava {

    public static void main(String[] args) {
        ClimbingStairsJava obj = new ClimbingStairsJava();
        System.out.println(obj.climbStairsSpaceOptimization(4));

        //if you need to find no of ways to climb n stairs
        // then you need (n + 1)th Fibonacci Number
        System.out.println(obj.climbStairsGoldenRatio(4 + 1));
    }

    /**
     * Approach 1: Recursion ❌ TLE ❌
     * Explanation: The recursive solution uses the concept of Fibonacci numbers to solve
     * the problem. It calculates the number of ways to climb the stairs by recursively
     * calling the climbStairs function for (n-1) and (n-2) steps. However,
     * this solution has exponential time complexity (O(2^n)) due to redundant calculations.
     *
     * @param n number of stairs
     * @return number of ways to climb
     */
    public int climbStairsRecursive(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
    }

    /**
     * Approach 2: Memoization
     * Explanation: The memoization solution improves the recursive solution by introducing
     * memoization, which avoids redundant calculations. We use an unordered map (memo)
     * to store the already computed results for each step n.
     * Before making a recursive call, we check if the result for the given n exists
     * in the memo. If it does, we return the stored value; otherwise,
     * we compute the result recursively and store it in the memo for future reference.
     *
     * @param n number of stairs
     * @return number of ways to climb
     */
    public int climbStairsRecursionMemoization(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return climbStairs(n, memo);
    }

    private int climbStairs(int n, Map<Integer, Integer> memo) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (!memo.containsKey(n)) {
            memo.put(n, climbStairs(n - 1, memo) + climbStairs(n - 2, memo));
        }
        return memo.get(n);
    }

    /**
     * Approach 3: Tabulation
     * Explanation: The tabulation solution eliminates recursion and uses a bottom-up approach
     * to solve the problem iteratively. It creates a DP table (dp) of size n+1 to store
     * the number of ways to reach each step. The base cases (0 and 1 steps) are
     * initialized to 1 since there is only one way to reach them.
     * Then, it iterates from 2 to n, filling in the DP table by summing up the values
     * for the previous two steps. Finally, it returns the value in the last
     * cell of the DP table, which represents the total number of ways to reach the top.
     *
     * @param n number of stairs
     * @return number of ways to climb
     */
    public int climbStairsTabulationMethod(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * Approach 4: Space Optimization
     * Explanation: The space-optimized solution further reduces the space complexity
     * by using only two variables (prev and curr) instead of an entire DP table.
     * It initializes prev and curr to 1 since there is only one way to reach
     * the base cases (0 and 1 steps). Then, in each iteration, it updates prev and curr
     * by shifting their values. curr becomes the sum of the previous two values,
     * and prev stores the previous value of curr.
     *
     * @param n number of stairs
     * @return number of ways to climb
     */
    public int climbStairsSpaceOptimization(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int prev = 1, curr = 1;
        for (int i = 2; i <= n; i++) {
            curr = prev + curr;
            prev = curr - prev;
        }
        return curr;
    }

    /**
     * Calculates the nth Fibonacci number using the Golden Ratio formula.
     * Time Complexity O(1)
     */
    public int climbStairsGoldenRatio(int n) {
        double sqrtOf5 = Math.sqrt(5.0);
        double goldenRatio = (1 + sqrtOf5) / 2;
        return (int) ((Math.pow(goldenRatio, n) - Math.pow(1 - goldenRatio, n)) / sqrtOf5);
    }
}
