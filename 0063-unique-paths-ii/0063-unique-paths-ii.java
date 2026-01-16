class Solution {
    static int[][] dp;
    static int pathh(int[][] obstacleGrid, int i, int j){
        if(i >= obstacleGrid.length || j >= obstacleGrid[0].length){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(obstacleGrid[i][j] == 1){
            dp[i][j] = 0;
        }
        else if(i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1){
            return 1;
        }
        else{
            dp[i][j] = pathh(obstacleGrid, i, j + 1) + pathh(obstacleGrid, i + 1, j);
        }
        return dp[i][j];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i = 0; i < obstacleGrid.length; i++) Arrays.fill(dp[i], -1);
        return pathh(obstacleGrid, 0, 0);
    }
}