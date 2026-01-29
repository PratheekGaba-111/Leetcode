class Solution {
    private void backTrack(int idx, int n, List<List<Integer>> ans , List<Integer> ds, int[] arr, int target){
        if(target == 0){
            ans.add(new ArrayList<>(ds));
        }
        for(int i = idx; i < n; i++){
            if(i > idx && arr[i] == arr[i - 1]) continue;
            if(arr[i] > target) break;
            ds.add(arr[i]);
            backTrack(i + 1, n, ans, ds, arr, target - arr[i]);
            ds.remove(ds.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //No duplicates so idx should move
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        int n = candidates.length;
        backTrack(0,n, ans, new ArrayList<>(), candidates, target);
        return ans;
    }
}