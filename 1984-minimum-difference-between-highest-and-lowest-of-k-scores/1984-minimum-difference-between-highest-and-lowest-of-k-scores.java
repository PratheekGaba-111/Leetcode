class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int i = k - 1;
        int ans = nums[i] - nums[0];
        for(i = k; i < nums.length; i++){
            ans = Math.min(ans, nums[i] - nums[i - k + 1]);
        }
        return ans;
    }
}