class Solution {
    private static final int MOD = 1000000007;
    private Integer[][][] memo;

    public int checkRecord(int n) {
        memo = new Integer[n + 1][2][3]; // Memoization table
        return helper(n, 0, 0); // Start with length n, 0 'A's, and 0 consecutive 'L's
    }

    private int helper(int n, int cntA, int concL) {
        if (n == 0) { // Base case
            return 1;
        }
        if (memo[n][cntA][concL] != null) { // Memoization check
            return memo[n][cntA][concL];
        }

        int result = 0;
        // Append 'P' (Present)
        result = (result + helper(n - 1, cntA, 0)) % MOD;
        // Append 'A' (Absent)
        if (cntA == 0) {
            result = (result + helper(n - 1, cntA + 1, 0)) % MOD;
        }
        // Append 'L' (Late)
        if (concL < 2) {
            result = (result + helper(n - 1, cntA, concL + 1)) % MOD;
        }

        memo[n][cntA][concL] = result; // Store the result in the memo table
        return result;
    }
}