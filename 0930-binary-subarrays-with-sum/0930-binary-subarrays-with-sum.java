class Solution {
    public int sumOfSubArrays(int[] nums, int goal){
        int r = 0, l = 0;
        int sum = 0;
        int count = 0; // for calculating curr sum
        int n = nums.length;
        if(goal < 0) return 0; // since goal can be 0 too so goal - 1 is 0
        while(r < n){
            sum += nums[r];
            while(l < n && sum > goal){ // to remove all sum > goal subarray
                sum -= nums[l];
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        return sumOfSubArrays(nums, goal) - sumOfSubArrays(nums, goal - 1);
    }
    // we cannot directly calculate number of subarrays with sum goal
}