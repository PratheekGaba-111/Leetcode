class Solution {
    public int maxSubArray(int[] nums) {
        // [] ,  [1,2]....
        /*  
                i loop is for generating all subarray from index i
                i = 0
                if n = 5
                0 1 2 3 4
                0 : 0 , 0 : 1, 0 : 2, 0 : 3, 0 : 4
                
                5 = 5
                5 6 = 11
                5 6 7 = 18
                5 6 7 8 = 26

                subarray -=>i [i,j]

        */
       /*
       for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += nums[j];
                maxi = Math.max(sum, maxi);
            }
        }
        return maxi;
        */
        /*
        kedane's algorithm
                idea -> add value to sum till its not negative
                sum negative --> reset sum = 0
                [-2,1,-3,4,-1,2,1,-5,4]
                sum = 0
                i : 0 -> sum = -2 sum = 0
                i : 1 -> sum = 1, maxi = 1
                i : 2 -> sum = -2 -> 0, maxi = 1
                i : 3 -> sum = 4, maxi = 4
                i : 4 -> sum = 3, maxi = 4
                i : 5 -> sum = 5, maxi = 5
                i : 6 -> sum = 6, maxi = 6
                i : 7 -> sum = 1, maxi = 6
                i : 8 -> sum = 5, maxi = 6

                ans -> maxi = 6

        */
        int maxi = Integer.MIN_VALUE, sum = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            maxi = Math.max(sum, maxi);
            if(sum < 0){
                sum = 0;
            }
        }
        return maxi;
    }
}