class Solution {
    public int countSubArrays(int[] ar, int k){
        int l = 0, r = 0, n = ar.length;
        int count = 0;
        int odd = 0;
        if(k < 0) return 0;
        while(r < n){
            if(ar[r] % 2 == 1) odd++;
            while(l <= r && odd > k){
                if(ar[l++] % 2 == 1) odd--;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return countSubArrays(nums, k) - countSubArrays(nums, k - 1);
    }
}