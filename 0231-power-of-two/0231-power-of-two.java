class Solution {
    public boolean isPowerOfTwo(int n) {
        int c = 0;
        for(int i = 0; i < 32; i++){
            if(((n >> i) & 1) == 1){
                c++;
            }
        }
        if(n > 0 && c == 1) return true;
        else return false;
            
        
    }
}