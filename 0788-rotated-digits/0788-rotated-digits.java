class Solution {
    public int rotatedDigits(int n) {
        int[] dp = new int[Math.max(n + 1, 10)];
        dp[0] = 1;
        dp[1] = 1;
        dp[8] = 1;
        dp[2] = 2; dp[5] = 2;
        dp[6] = 2; dp[9] = 2;
        dp[3] = 0; dp[4] = 0; dp[7] = 0;
        int count = 0;
        for(int i = 1; i <= n; i++){
            int val = i;
            boolean change = true, change2 = false;
            while(val > 0){
                if(dp[val % 10] == 0){
                    change = false;
                    break;
                }
                if(dp[val % 10] == 2) change2 = true;

                val /= 10;
            }
            if(change && change2) count++;
        }
        return count;
    }
}