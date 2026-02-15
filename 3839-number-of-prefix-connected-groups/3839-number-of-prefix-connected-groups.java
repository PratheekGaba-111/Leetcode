class Solution {
    public int prefixConnected(String[] words, int k) {
        HashMap<String, Integer> mp = new HashMap<>();
        for(String wrd : words){
            if(wrd.length() < k) continue;
            String x = wrd.substring(0, k);
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }
        int ctr = 0;
        for(String key : mp.keySet()){
            if(mp.get(key) > 1) ctr++;
        }
        return ctr;
    }
}