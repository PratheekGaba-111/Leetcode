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
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!stk.isEmpty() && ar[stk.peek()] >= ar[i]){
                stk.pop();
            }
            psl[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(i);
        }
        stk.clear();
        for(int i = n - 1; i >= 0; i--){
            while(!stk.isEmpty() && ar[stk.peek()] >= ar[i]){
                stk.pop();
            }
            nsr[i] = stk.isEmpty() ? n : stk.peek();
            stk.push(i);
        }
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            int area = (nsr[i] - psl[i] - 1) * ar[i];
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}