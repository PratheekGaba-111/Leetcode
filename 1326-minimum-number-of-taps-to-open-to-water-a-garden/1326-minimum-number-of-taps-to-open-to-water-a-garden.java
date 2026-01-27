class Solution {
    public int minTaps(int n, int[] ranges) {
        int[][] arr = new int[n + 1][2];
        for(int i = 0; i <= n; i++){
            arr[i][0] = Math.max(0, i - ranges[i]);
            arr[i][1] = Math.min(n, i + ranges[i]);
        }
        Arrays.sort(arr, (a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        int startIdx = 0;
        int ptr = 0;
        int ctr = 0;
        int globalEnd = 0;
        while(globalEnd < n){
            int curr = globalEnd;
            while(ptr <= n && arr[ptr][0] <= globalEnd){
                curr = Math.max(curr, arr[ptr][1]);
                ptr++;
            }
            if(curr == globalEnd) return -1;
            ctr++;
            globalEnd = curr;
        }
        return ctr;
    }
}