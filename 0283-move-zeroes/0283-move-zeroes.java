class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = 0;
        for(int i = 0; i < n; i++){
            j = Math.max(i, j);
            if(nums[i] == 0){
                // j++;
                boolean moved = false;
                while(j < n && nums[j] == 0){
                    j++;
                    moved = true;
                }
                if(moved && j < n){
                    nums[i] = nums[i] ^ nums[j];
                    nums[j] = nums[i] ^ nums[j];
                    nums[i] = nums[i] ^ nums[j];
                }
            }
            // if(j >= n) break;
        }
    }
    /*
    we know that
        0 1 0 3 12

        op 
        1 3 12 0 0

        but
        lets say l = 0, r = 0
        we need to fin r pointer till next non zero value



    */
}