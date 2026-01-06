class Solution {
    boolean check(List<String> ds){
        String top = ds.get(0), left = ds.get(1), right = ds.get(2), bottom = ds.get(3);

        if(top.charAt(0) != left.charAt(0)) return false;
        if(top.charAt(3) != right.charAt(0)) return false;
        if(bottom.charAt(0) != left.charAt(3)) return false;
        if(bottom.charAt(3) != right.charAt(3)) return false;
        return true; 
    }
    void backTrack(List<List<String>> ans, List<String> ds, String[] words, int n, int pick, boolean[] visited){
        if(pick == 4){
            if(check(ds)){
                ans.add(new ArrayList<>(ds));
            }
        }
        if(pick < 4){
            for(int i = 0; i < n; i++){
                if(!visited[i]){
                    visited[i] = true;
                    ds.add(words[i]);
                    backTrack(ans, ds, words, n, pick + 1, visited);
                    ds.remove(ds.size() - 1);
                    visited[i] = false;
                }
            }

        }

    }
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ans = new ArrayList<>();
        Arrays.sort(words);
        boolean[] visited = new boolean[words.length]; 
        backTrack(ans, new ArrayList<>(), words, words.length, 0, visited);
        return ans;
    }
}