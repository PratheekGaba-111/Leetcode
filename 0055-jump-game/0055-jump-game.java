class Solution {
    public boolean canJump(int[] nums) {
        /*
            from ith index we can jump to i + ar[i] indexes

        */
        if(nums.length == 1) return true;
        // boolean[] dp = new boolean[nums.length];
        int val = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(val != 0){
                // dp[i] = true;
                val--;
                val = Math.max(val, nums[i]);
            }
            else{
                return false;
            }
        }
        return true;
    }
}