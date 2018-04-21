//easy binary search
class Solution {
    public int searchInsert(int[] nums, int target) {
        if( nums == null  ) return 0;
        if( nums.length == 0 ) return 0;
        int len = nums.length;
        int low = 0;
        int high = nums.length - 1;
        int mid = ( low + high ) / 2;
        while( low <= high ){
            mid = ( low + high ) / 2;
            if ( target == nums[mid] ) return mid;
            else if ( target < nums[mid] ) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return nums[mid] > target ? mid : mid+1 ;
    }
}
