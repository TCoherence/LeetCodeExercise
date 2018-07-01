class Solution {
    public int findMin(int[] nums) {
        // check para
        if ( nums == null || nums.length == 0 ) throw new java.lang.NullPointerException("Null Pointer or empty array detected...");
        
        // normal op
        int len = nums.length;
        int hi = len - 1;
        int lo = 0;
        int mid = lo + (hi - lo) / 2;
        // the following is necessary?
        if (len > 1 && nums[len - 1] < nums[len - 2]) return nums[len - 1];
        if (len > 1 && nums[len - 1] > nums[0]) return nums[0];
        
        while ( hi > lo ){
            if ( nums[mid] < nums[hi] ) hi = mid;
            else if ( nums[mid] > nums[hi] ) lo = mid + 1;
            else hi--;
            mid = lo + (hi - lo) / 2;
        }
        
        // return result
        return nums[mid];
    }
}

// Note
// 1. change mid > lo to mid > hi (line 17)
// 2. when mid == hi == lo, just change the upper boundry, lo is the same
