class Solution {
    public int search(int[] nums, int target) {
        if ( nums == null ) return -1;
        int len = nums.length;
        //if ( len == 1 ) return target == nums[0];
        int low = 0, high = len - 1;
        int mid = (low+high) / 2;
        // find the lowest
        while( low < high ){
            mid = (low+high) / 2;
            if ( nums[mid] > nums[high] ) low = mid+1;
            else high = mid;
        }
        high = low+len-1;
        while ( low <= high ){
            mid = (low+high) / 2;
            if(nums[mid%len] ==  target) return mid%len;
            if(nums[mid%len] > target ) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}
