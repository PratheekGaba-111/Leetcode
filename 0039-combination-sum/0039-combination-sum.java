class Solution {
    void bt(List<List<Integer>> ans, ArrayList<Integer> ds, int[] candidates, int idx, int target){
        if(idx == candidates.length){
            if(target == 0) ans.add(new ArrayList<>(ds));
            return;
        }
        if(candidates[idx] <= target){
            // pick
            ds.add(candidates[idx]);
            bt(ans, ds, candidates, idx, target - candidates[idx]);
            ds.remove(ds.size() - 1);
        }
        // no pick
        bt(ans, ds, candidates, idx + 1, target);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        bt(ans, new ArrayList<>(), candidates, 0, target);
        return ans;
    }
}