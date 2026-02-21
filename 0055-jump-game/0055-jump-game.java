class Solution {
    public boolean canJump(int[] nums) {
        // initially at first position
        // so we can jump upto all 2 blocks right
        // so we can make all the possible jumps from i + 1 to i + 2
        // so all those indexes are reachable
        // so lets say to reach last index
        // we must need an index such that from that index coming to last index is possible
        // so lets sayyyyyyyyyyyyy we start from 0 to n
        int n = nums.length;
        if(n == 1) return true;
        boolean[] dp = new boolean[n];
        int val = nums[0];
        for(int i = 0; i < n; i++){
            if(val != 0){
                dp[i] = true;
                val = Math.max(val - 1, nums[i]);
            }
        }
        return dp[n - 1];
    }
}