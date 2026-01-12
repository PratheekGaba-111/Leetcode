class Solution {
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[] ar = new int[c];
        int area = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(matrix[i][j] == '1'){
                    ar[j]++;
                }else{
                    ar[j] = 0;
                }
            }
            area = Math.max(area, calcArea(ar));
        }
        return area;
    }
    private int calcArea(int[] ar){
        int n = ar.length;
        int[] nsr = new int[n];
        int[] psl = new int[n];
        psl[0] = -1;
        nsr[n - 1] = n;
        for(int i = 1; i < n; i++){
            int prev = i - 1;
            while(prev >= 0 && ar[prev] >= ar[i]){
                prev = psl[prev];
            }
            psl[i] = prev;
        }
        for(int i = n - 2; i >= 0; i--){
            int prev = i + 1;
            while(prev < n && ar[prev] >= ar[i]){
                prev = nsr[prev];
            }
            nsr[i] = prev;
        }
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            int area = (nsr[i] - psl[i] - 1) * ar[i];
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}