class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[]{-1,-1};
        int len = nums.length;
        int lo = 0;
        int hi = len - 1;
        int mid = (lo+hi) / 2;
        while( lo <= hi ){
            mid = (lo+hi) / 2;
            if ( nums[mid] > target ) hi = mid - 1;
            else if ( nums[mid] < target ) lo = mid + 1;
            else break;
        }
        if ( hi < lo ) return ret;
        int left = mid;
        int right = mid;
        if ( mid - 1 >= 0 && nums[mid-1] == target ){
            lo = 0;
            hi = mid - 1;
            while ( lo <= hi){
                mid = (lo+hi) / 2;
                if ( nums[mid] < target ) lo = mid + 1;
                else hi = mid - 1;
            }
            left = lo;
        }
        if ( mid + 1 < len && nums[mid+1] == target ){
            lo = mid + 1;
            hi = len - 1;
            while( lo <= hi ) {
                mid = (lo+hi) / 2;
                if ( nums[mid] > target ) hi = mid - 1;
                else lo = mid + 1;
            }
            right = lo - 1;
        }
        ret[0] = left;
        ret[1] = right;
        return ret;
        
    }
}
