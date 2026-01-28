class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 1, r = nums.length - 2;
        if(nums.length == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[r] != nums[r + 1]) return nums[r + 1];
        while(l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] == nums[mid + 1]){
                if(mid % 2 == 0) l = mid + 1;
                else r = mid - 1;
            }
            else if(nums[mid - 1] == nums[mid]){
                if(mid % 2 == 0) r = mid - 1;
                else l = mid + 1;
            }
            else{
                return nums[mid];
            }
        }
        return -1;
    }
}