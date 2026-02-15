class Solution {
    public int almostPalindromic(String s) {
        // This is definitely a constructive algorithm as it was not solved with lps O(n) algo ....
        // sliding window doesnt work here because we dont know the expand and shrink conditions
        // so it must be brute force in optimal way
        // can we do it
        // n^2 loops and we need to check the substring in an optimal way...
        // but we need to do something like carryforward but how is that even possible
        // as we dont know where the removal should be done........... 
        // so was the previous approach correcct? and was it with just a tweak?
        // because if we remove a char at any instance then we should be able to get the max length right and we need to get those indexes and check if our previous removal character index lies among them
        // so if we check with the start and end indexes if it lies then maybe theres a chance we can get the overlapping condition or not and then we can do it
        int n = s.length();
        int ans = 0;
        for(int k = 0; k < n; k++){
            StringBuilder sb = new StringBuilder(s);
            sb.deleteCharAt(k);
            char[] T = preprocess(sb.toString());
            int x = T.length;
            int[] P = new int[x];
            int c = 0, r = 0;
            for(int i = 1; i < x - 1; i++){
                int mirr =  2 * c - i;
                if(i < r){
                    P[i] = Math.min(r - i, P[mirr]);
                }
                while(T[i - (P[i] + 1)] == T[i + (P[i] + 1)]){
                    P[i]++;
                }
                if(i + P[i] > r){
                    c = i;
                    r = i + P[i];
                }
            }
            int start = 0, maxLen = 0, ctrindex = 0;
            for(int i = 0; i < x; i++){
                if(P[i] > maxLen){
                    ctrindex = i;
                    maxLen = P[i];
                }
            }
            //P[i] represesnt the length of palindromic substring from that centre to any one of its ends
            start = (ctrindex - maxLen)/2;
            int end = start + maxLen;
            if(k >= start && k <= end) maxLen++;
            else if(k + 1 == start || k - 1 == end) maxLen++;
            ans = Math.max(maxLen, ans);
        }
        return ans;
    }
    public char[] preprocess(String s){
        char[] T = new char[s.length() * 2 + 3];
        // 2 * l + 3 because the string will be ^#a#a#b#c#$ so there are n letters, n hashtags and 2 extra terminating symbolssssssssssssssssssss
        // this algo is longest palindromic substring >)))
        T[0] = '^';
        int k = 1;
        for(int i = 0; i < s.length(); i++){
            T[k++] = '#';
            T[k++] = s.charAt(i);
        }
        T[k++] = '#';
        T[k++] = '$';
        return T;
    }
}