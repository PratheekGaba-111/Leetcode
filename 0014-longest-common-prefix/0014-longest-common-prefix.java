class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        String longestPrefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(!strs[i].startsWith(longestPrefix)){
                //shorten the prefix
                longestPrefix = longestPrefix.substring(0 , longestPrefix.length() - 1);
            }
            if(longestPrefix.isEmpty()){
                return "";
            }
        }
        return longestPrefix;
    }
}