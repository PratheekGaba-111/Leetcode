class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int l = 0, r = 0;
        while(r < n){
            // we swap l and r if r is nonzero
            if(nums[r] != 0){
                // swap l and r
                //swap
                int t = nums[l];
                nums[l] = nums[r];
                nums[r] = t;
                l++;
            }
            r++;
        }
        return;
    }
}