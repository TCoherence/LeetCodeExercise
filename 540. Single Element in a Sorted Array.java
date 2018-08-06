class Solution {
    public int singleNonDuplicate(int[] nums) {
        if ( nums == null || nums.length == 0 || (nums.length & 1) == 0 ) return 0;
        
        int len = nums.length;
        if ( len == 1 ) return nums[0];
        if ( nums[0] != nums[1] ) return nums[0];
        if ( nums[len - 1] != nums[len - 2] ) return nums[len - 1];
        int lo = 2, hi = len - 3;
        int mid = lo + (hi - lo) / 2;
        while ( lo <= hi ) {
            mid = lo + (hi - lo) / 2;
            if ( nums[mid] == nums[mid + 1] ) {
                if ( ((hi - mid + 1) & 1) == 0 )
                    hi = mid - 1;
                else
                    lo = mid + 2;
            }
            else if ( nums[mid] == nums[mid - 1] ) {
                if ( ((mid - lo + 1) & 1) == 0 ) 
                    lo = mid + 1;
                else 
                    hi = mid - 2;
            }
            else
                break;
        }
        return nums[mid];
    }
}
