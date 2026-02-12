class Solution {
    public int longestBalanced(String s) {
        int ans = 2;
        int n = s.length();
        if(n == 1) return 1;
        for(int i = 0; i < n; i++){
            int[] cnt = new int[26];
            cnt[s.charAt(i) - 'a']++;
            for(int j = i + 1; j < n; j++){
                cnt[s.charAt(j) - 'a']++;
                if(check(cnt)){
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
    public boolean check(int[] cnt){
        int prev = 0;
        for(int i : cnt){
            if(i == 0) continue;
            if(prev == 0) prev = i;
            if(prev != i) return false;
        }
        return true;
    }
}