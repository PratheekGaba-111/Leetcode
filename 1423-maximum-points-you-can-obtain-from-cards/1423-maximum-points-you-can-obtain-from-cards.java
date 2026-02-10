class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;
        for(int i : cardPoints) sum += i;
        int csum = 0;
        int maxSum = 0;
        for(int i = 0; i < n - k; i++){
            csum += cardPoints[i];
        }
        maxSum = sum - csum;
        for(int i = n - k; i < n; i++){
            csum -= cardPoints[i - (n - k)];
            csum += cardPoints[i];
            maxSum = Math.max(sum - csum, maxSum);
        }
        return maxSum;
    }
    // greedy wont workkk so we have to think something crazy here
    // take some time nd comeback
}