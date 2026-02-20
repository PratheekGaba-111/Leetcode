class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = 0;
        for(int i = 0; i < n; i++){
            j = i + 1;
            if(nums[i] == 0){
                while(j < n && nums[j] == 0) j++;
                if(j < n){
                    nums[i] = nums[i] ^ nums[j];
                    nums[j] = nums[i] ^ nums[j];
                    nums[i] = nums[i] ^ nums[j];
                }
            }
            if(j >= n) break;
        }
    }
}