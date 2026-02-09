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
        int maxFreq = 0;
        while(r < n){
            // expand
            freq[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(r) - 'A']);
            while((r - l + 1) - maxFreq > k){
                freq[s.charAt(l++) - 'A']--;
            }
            len = Math.max(len, r - l + 1);
            r++;
        }
        return len;
    }
}