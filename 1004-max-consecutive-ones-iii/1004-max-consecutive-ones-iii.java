class Solution {
    public int longestOnes(int[] nums, int k) {
        int len = 0;
        int n = nums.length;
        int ctr = 0;
        int l = 0, r = 0;
        while(l < n && r < n){
            //expand
            while(r < n && ctr <= k){
                if(nums[r] == 0) ctr++;
                if(ctr <= k) len = Math.max(len, r - l + 1);
                r++;
            }
            if(r == n) break;
            while(l < r && ctr > k){
                if(nums[l] == 0) ctr--;
                l++;
            }
        }
        return len;
    }
}