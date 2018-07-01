class Solution {
    public int findMin(int[] nums) {
        // check para
        if (nums == null || nums.length == 0) throw new java.lang.NullPointerException("para int[] nums is invalid");
        
        // normal op
        int len = nums.length;
        int hi = len - 1;
        int lo = 0;
        int mid = lo + (hi - lo) / 2; // in case of overflow
        
        while ( hi != lo ){
            // two corner cases:
            // 1. min in 0th
            // 2. min in (n-1)th
            if ( nums[mid] < nums[hi] ) hi = mid;
            // else if ( nums[mid] > nums[lo] ) lo = mid + 1;
            else lo = mid + 1;
            mid = lo + (hi - lo) / 2;
        }
        return nums[mid];
    }
}
