class Solution {
    public long rob(int[] nums, int[] colors) {
        // given house robber
        // given two arr
        // nums and colors
        // nums[i] - money && colors [i] is color code of house
        // we cannot rob if both share same color
        // so dp[i] is ith index max money
        int n = nums.length;
        long[] dp = new long[n];
        dp[0] = nums[0];
        for(int i = 1; i < n; i++){
            // so if we have col0r[i] == color[i - 1] so we dont use the curr value 
            if(colors[i] == colors[i - 1]){
                if(i >= 2) dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
                else dp[i] = Math.max(nums[i], dp[i - 1]);
            }
            else dp[i] = dp[i - 1] + nums[i];
        }
        return dp[n - 1];
    }
    // failed first attempt lets go dry run
    /*
        nums = 1 4 3 5 colors = 1 1 2 2 
        so at first dp[0] = 1
        now when we come at i = 2
        so we either do dp[i - 2] + nums[i] or dp[i - 1]
        where i - 2 is basically null soo.. 
        now dp[1] = 4
        dp[2] = dp[i - 1] + the nums[i]

    */
}