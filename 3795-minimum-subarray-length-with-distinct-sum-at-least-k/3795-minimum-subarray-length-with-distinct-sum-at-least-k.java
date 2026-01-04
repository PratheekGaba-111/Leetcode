class Solution {
    public int minLength(int[] nums, int k) {
        int l = 0, r = 0;
        long sum = 0;
        int n = nums.length;
        int len = n + 1;
        HashMap<Integer, Integer> set = new HashMap<>();
        while(l < n && r < n){
            while(sum < k && r < n){
                if(!set.containsKey(nums[r])){
                    set.put(nums[r], 1);
                    sum += nums[r];
                }
                else{
                    set.put(nums[r], set.get(nums[r]) + 1);
                }
                r++;
            }
            while(sum >= k && l <= r){
                len = Math.min(len, r - l);
                set.put(nums[l], set.get(nums[l]) - 1);
                if(set.get(nums[l]) == 0){
                    set.remove(nums[l]);
                    sum -= nums[l];
                }
                l++;
            }
        }
        if(len == n + 1) return -1;
        return len;
    }
}