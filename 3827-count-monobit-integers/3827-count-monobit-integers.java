class Solution {
    public int countMonobit(int n) {
        int ctr = 1;
        for(int i = 1; i <= n; i+=2){
            boolean flag = true;
            int t = i;
            while(t > 0){
                if((t & 1) == 0){
                    flag = false;
                    break;
                }
                t >>= 1;
            }
            if(flag) ctr++;
        }
        return ctr;
    }
}