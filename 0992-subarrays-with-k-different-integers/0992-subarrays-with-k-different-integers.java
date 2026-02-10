class Solution {
    public int countSbA(int[] nums, int k){
        int l = 0, r = 0;
        int n = nums.length;
        int count = 0;
        if(k < 0) return 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        while(r < n){
            mp.put(nums[r], mp.getOrDefault(nums[r], 0) + 1);
            while(l <= r && mp.size() > k){
                mp.put(nums[l], mp.get(nums[l]) - 1);
                if(mp.get(nums[l]) == 0) mp.remove(nums[l]);
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countSbA(nums, k) - countSbA(nums, k - 1); 
    }
}