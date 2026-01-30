class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length, ans = 0;
        for(int bit = 0; bit < 32; bit++){
            int ct = 0;
            for(int i = 0; i < n; i++){
                if(((nums[i] >> bit) & 1) == 1) ct++;
            }
            if(ct % 3 != 0) ans |= 1 << bit;
        }
        return ans;
    }
}