class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for(String word : words){
            int wt = 0;
            for(char c : word.toCharArray()){
                wt += weights[c - 'a'];
            }
            wt %= 26;
            sb.append((char) ('z' - wt));
        }
        return sb.toString();
    }
}