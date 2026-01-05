class Solution {
    public long maximumHappinessSum(int[] happiness, int k){
        Arrays.sort(happiness);
        int idx = happiness.length - k;
        long sum = 0, ct = 0;
        for(int i = happiness.length - 1; i >= idx; i--){
            sum += Math.max(happiness[i] - ct++, 0);
        }
        return sum;
    }
}