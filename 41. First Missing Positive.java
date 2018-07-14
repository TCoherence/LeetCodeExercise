class Solution {
    public int firstMissingPositive(int[] nums) {
        // check para
        if ( nums == null || nums.length == 0 ) return 1;
        
        int len = nums.length;
        int[] res = new int[len];
        for ( int i = 0; i < len; i++ ) {
            if ( nums[i] > 0 && nums[i] <= len) 
                res[nums[i] - 1] = 1;
        }
        for ( int i = 0; i < len; i++ ) {
            if ( res[i] == 0 ) return i + 1;
        }
        return len + 1;
        
    }
}
