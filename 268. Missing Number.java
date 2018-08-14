class Solution {
    public int missingNumber(int[] nums) {
        if ( nums == null || nums.length == 0 ) return 0;
        
        int len = nums.length;
        int miss = len;
        for( int i = 0; i < len; i++){
            miss = miss ^ i ^ nums[i];
        }
        return miss;
    }
}
