class Solution {
    public int minOperations(int[] nums, int[] target) {
        HashSet<Integer> st = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != target[i]) st.add(nums[i]);
        }
        return st.size();
    }
}