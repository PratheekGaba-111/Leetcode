class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        lmax[0] = 0;
        rmax[n - 1] = 0;
        for(int i = 1; i < n; i++){
            lmax[i] = Math.max(lmax[i - 1], height[i - 1]);
        }
        for(int i = n - 2; i >= 0; i--){
            rmax[i] = Math.max(rmax[i + 1], height[i + 1]);
        }
        int ans = 0;
        for(int i = 1; i < n - 1; i++){
            if(lmax[i] > height[i] && rmax[i] > height[i]){
                ans += Math.max(0, Math.min(rmax[i], lmax[i]) - height[i]);
            }
        }
        // for(int i : lmax) System.out.print(i + " ");
        return ans;
    }
}