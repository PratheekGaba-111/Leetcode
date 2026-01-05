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
/*

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
*/