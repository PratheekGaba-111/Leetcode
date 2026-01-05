class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < k; i++){
            pq.add(happiness[i]);
        }
        for(int i = k; i < happiness.length; i++){
            pq.add(happiness[i]);
            pq.poll();
        }
        long sum = 0;
        int itr = k;
        while(!pq.isEmpty()){
            itr--;
            sum += Math.max((pq.poll() - itr), 0);
        }
        return sum;
    }
}