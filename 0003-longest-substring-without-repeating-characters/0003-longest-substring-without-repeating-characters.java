class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int l = 0, r = 0;
        int n = s.length();
        int len = 0;
        while(l < n && r < n){
            // expand
            while(r < n && freq[s.charAt(r)] == 0){
                freq[s.charAt(r)]++;
                len = Math.max(len, r - l + 1);
                r++;
            }
            // shrink
            if(r == n) break;
            while(l < r && freq[s.charAt(r)] != 0){
                freq[s.charAt(l)]--;
                l++;
            }
        }
        return len;
    }
}