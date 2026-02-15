class Solution {
    public void insert(int[] trie, int val){
        int x = 1;
        for(int i = 14; i >= 0; i--){
            // insert it
            int bit = (val >> i) & 1;
            if(bit == 1) x = 2 * x + 1;
            else x = 2 * x;
            trie[x]++;
        }
    }
    public void delete(int[] trie, int val){
        int x = 1;
        for(int i = 14; i >= 0; i--){
            // insert it
            int bit = (val >> i) & 1;
            if(bit == 1) x = 2 * x + 1;
            else x = 2 * x;
            trie[x]--;
        }
    }
    public int search(int[] trie, int val){
        int x = 1, ans = 0;
        for(int i = 14; i >= 0; i--){
            int bit = (val >> i) & 1;
            int rbit = bit ^ 1;
            if(rbit == 0){
                // we can use that
                if(trie[2 * x] > 0){
                x = x * 2; // we can use that
                ans |= (1 << i);
                }
                else{
                    x = x * 2 + 1;
                }
            }
            else{
                if(trie[2 * x + 1] > 0){
                    x = x * 2 + 1;
                    ans |= (1 << i);
                }
                else{
                    x = x * 2;
                }
            }
        }
        return ans;
    }
    public int maxXor(int[] nums, int k) {
        /// okay so now I am upsolving this question using MinMax Sliding window and prefix xor trie
        // first lets implement min-max sliding window from scratch
        // we dont have multiset so in java we use arrayDeques
        ArrayDeque<Integer> minD = new ArrayDeque<>();
        ArrayDeque<Integer> maxD = new ArrayDeque<>();
        // so for each index we need to you know get the max pref Xor
        // and insert it into the trie
        int ans = 0;
        int n = nums.length;
        int[] trie = new int[1 << 16 + 2];
        int[] pref = new int[n + 1];
        for(int i = 0; i < n; i++){
            pref[i + 1] = nums[i] ^ pref[i];
        }
        int l = 0, value = 0;
        insert(trie, pref[0]);
        for(int i = 0; i < n; i++){
            insert(trie, pref[i + 1]); // i + 1 is basically pref xor till i 
            // shrink
            value = Math.max(value, nums[i]);
            // before shrinking add the maxD and minD
            while(!minD.isEmpty() && nums[minD.peekLast()] >= nums[i]) minD.pollLast();
            minD.addLast(i);
            while(!maxD.isEmpty() && nums[maxD.peekLast()] <= nums[i]) maxD.pollLast();
            maxD.addLast(i);
            // shrink now
            while(l <= i && nums[maxD.peekFirst()] - nums[minD.peekFirst()] > k){
                if(minD.peekFirst() == l) minD.pollFirst();
                if(maxD.peekFirst() == l) maxD.pollFirst();
                delete(trie, pref[l]);
                l++;
            }// it stops shrinking at l == i
            // so our trie must contain l == i value
            // so my search should atleast return the same value right?
            // but it is returning 0? whys 
            ans = Math.max(ans, search(trie, pref[i + 1]));// iska maximum xor is required

        }
        if(n == 1 || k == 0) return value;
        return ans;
    }
}