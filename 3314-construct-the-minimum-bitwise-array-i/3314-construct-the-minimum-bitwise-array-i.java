class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        int k = 0;
        for(int i : nums){
            boolean found = false;
            for(int j = 0; j <= i; j++){
                if((j | (j + 1)) == i){
                    ans[k++] = j;
                    found = true;
                    break;
                }
            }
            if(!found) ans[k++] = -1;
        }
        return ans;
    }
}