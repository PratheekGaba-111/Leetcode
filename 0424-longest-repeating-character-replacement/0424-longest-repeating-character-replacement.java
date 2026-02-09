class Solution {
    public boolean check(int[] freq, int k){
        int fr = 0;
        int sum = 0;
        for(int i = 0; i < 26; i++){
            if(freq[i] > fr){
                fr = freq[i];
            }
            sum += freq[i];
        }
        return (sum - fr) <= k;
    }
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0, r = 0, len = 0;
        int[] freq = new int[26];
        while(r < n){
            // expand
            while(r < n){
                // inc
                freq[s.charAt(r) - 'A']++;
                if(check(freq, k)){
                    len = Math.max(len, r - l + 1);
                    r++;
                }
                else{
                    r++;
                    break;
                }
            }
            if(r == n) break;
            while(l < r){
                if(!check(freq, k)){
                    freq[s.charAt(l) - 'A']--;
                    l++;
                }
                else{
                    break;
                }
            }
        }
        return len;
    }
}