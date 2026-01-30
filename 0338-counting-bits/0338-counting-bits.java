class Solution {
    public int[] countBits(int n) {
        int[] ar = new int[n + 1];
        for(int i = 0; i <= n; i++){
            ar[i] = kernighanAlgo(i);
        }
        return ar;
    }
    public static int kernighanAlgo(int i){
        int ct = 0;
        while(i > 0){
            i &= (i - 1);
            ct++;
        }
        return ct;
    }
}