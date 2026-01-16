class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[2][n];
        Arrays.fill(dp[0], 1);
        dp[1][0] = 1;
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i & 1][j] = dp[(i - 1) & 1][j] + dp[i & 1][j - 1];
            }
        }
        return dp[(m - 1) & 1][n - 1];
    }
}