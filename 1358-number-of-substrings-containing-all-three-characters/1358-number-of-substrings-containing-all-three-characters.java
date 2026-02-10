class Solution {
    public int countSubArrays(String s, int distinct){
        int n = s.length();
        int l = 0, r = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        int count = 0;
        while(r < n){
            mp.put(s.charAt(r), mp.getOrDefault(s.charAt(r), 0) + 1);
            while(l < r && mp.size() > distinct){
                mp.put(s.charAt(l), mp.get(s.charAt(l)) - 1);
                if(mp.get(s.charAt(l)) == 0) mp.remove(s.charAt(l));
                l++;
            }
            if(mp.size() <= distinct) count += (r - l + 1);  // counts only valid distinct stuff
            r++;
        }
        return count;
    }
    public int numberOfSubstrings(String s){
        int n = s.length();
        long tot = (1L * n * (n + 1))/2;
        return (int) (tot - countSubArrays(s, 2));
    }
}