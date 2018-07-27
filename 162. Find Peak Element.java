class Solution {
    public int findPeakElement(int[] nums) {
        // check param
        if ( nums == null || nums.length == 0 ) return -1;
        if ( nums.length == 1 ) return 0;
        
        int lo = 0, hi = nums.length - 1;
        int mid = lo + (hi - lo) / 2;
        if ( nums[lo] > nums[lo + 1] ) 
            return lo;
        if ( nums[hi] > nums[hi - 1] ) 
            return hi;
        while ( lo < hi ) {
            mid = lo + (hi - lo) / 2;
            // System.out.printf("lo = %d, hi = %d, mid = \n", lo, hi);
            if ( mid == 0 ) {
                if (nums[mid] > nums[mid + 1])
                    return mid;
                else 
                    lo = mid + 1;
            }
            else if ( mid == nums.length - 1 ) {
                if (nums[mid] > nums[mid - 1])
                    return mid;
                hi = mid - 1;
            }
            else {
                if ( nums[mid - 1] > nums[mid])
                    hi = mid - 1;
                else if ( nums[mid] < nums[mid + 1] ) 
                    lo = mid + 1;
                else 
                    return mid;
            }
        }
        mid = lo + (hi - lo) / 2;
        return mid;
    }
}
