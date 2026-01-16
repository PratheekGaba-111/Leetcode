class Solution {
    // static int[][] dp;
    /*
    static int pathss(int i, int j, int m, int n){
        if(i >= m || j >= n) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(i == m - 1 && j == n - 1){
            return 1;
        }
        dp[i][j] = pathss(i + 1, j, m, n) + pathss(i, j + 1, m, n);
        return dp[i][j];
    }
    */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        /*
        for(int i = 0; i < m; i++) Arrays.fill(dp[i], -1);
        return pathss(0, 0, m, n);
        */
        dp[0][0] = 1;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) continue;
                dp[i][j] = 0;
                if(j != 0){
                    dp[i][j] += dp[i][j - 1];
                }
                if(i != 0){
                    dp[i][j] += dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}