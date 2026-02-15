class Solution {
    public long rob(int[] nums, int[] colors) {
        // given house robber
        // given two arr
        // nums and colors
        // nums[i] - money && colors [i] is color code of house
        // we cannot rob if both share same color
        // so dp[i] is ith index max money
        int n = nums.length;
        // long[] dp = new long[n];
        // dp[0] = nums[0];
        if(n == 1) return nums[0];
        long prev2 = nums[0];
        long prev1 = 0;
        if(colors[0] == colors[1]){
            prev1 = Math.max(nums[0], nums[1]);
        }
        else{
            prev1 = nums[0] + nums[1];
        }
        for(int i = 2; i < n; i++){
            // so if we have color[i] == color[i - 1] so we dont use the curr value 
            long curr = 0;
            if(colors[i] == colors[i - 1]) curr = Math.max(prev2 + nums[i], prev1);
            else curr = prev1 + nums[i];
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
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