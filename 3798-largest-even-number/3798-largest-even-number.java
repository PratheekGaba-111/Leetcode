class Solution {
    public String largestEven(String s) {
        int i = s.length() - 1;
        for(i = s.length() - 1; i >= 0; i--){
            if((s.charAt(i) - '0') % 2 == 0){
                break;
            }
        }
        return s.substring(0, i + 1);
    }
}