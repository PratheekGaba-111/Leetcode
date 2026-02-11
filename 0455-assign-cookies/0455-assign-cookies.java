class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int p1 = 0, p2 = 0, ctr = 0;
        int n = g.length, m = s.length;
        while(p1 < n && p2 < m){
            if(s[p2] >= g[p1]){
                p1++;
                ctr++;
            }
            p2++;
        }
        return ctr;
    }
}