class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        // if(m == 0){
        //     if(n % 2 == 0) return (nums2[n/2] + nums2[(n/2) + 1])/2;
        //     else return nums2[n/2];
        // }
        // if(n == 0){
        //     if(m % 2 == 0) return (nums1[m/2] + nums1[(m/2) + 1])/2;
        //     else return nums1[m/2];
        // }
        int len = m + n;
        int pos_req = (len % 2 == 0)? 2 : 1;
        double m1 = 0, m2 = 0;
        int p1 = 0, p2 = 0;
        for(int count = 0; count <= len/2; count++){
            m2 = m1;
            if(p1 != m && p2 != n){
                if(nums1[p1] > nums2[p2]){
                    m1 = nums2[p2++];
                }
                else{
                    m1 = nums1[p1++];
                }
            }
            else if(p1 != m){
                m1 = nums1[p1++];
            }
            else{
                m1 = nums2[p2++];
            }
        }
        if(pos_req == 2){
            return (m1 + m2)/2;
        }
        else return m1;
    }
}