class Solution {
    public String minWindow(String s, String t) {
        int[] mps = new int[128];
        // int[] mpt = new int[128];
        for(char c : t.toCharArray()) mps[c]++;
        int l = 0, r = 0, n = s.length();
        int p1 = 0, p2 = 0, maxLen = n + 1;
        int count = 0;
        while(r < n){
            char y = s.charAt(r);
            mps[y]--;
            if(mps[y] >= 0) count++;
            while(l <= r && count >= t.length()){
                char x = s.charAt(l);
                mps[x]++;
                if(mps[x] > 0) count--;
                if((r - l + 1) < maxLen){
                    maxLen = r - l + 1;
                    p1 = l; p2 = r;
                }
                l++;
            }
            r++;
        }
        if(maxLen == n + 1) return "";
        return s.substring(p1, p2 + 1);

    }
}