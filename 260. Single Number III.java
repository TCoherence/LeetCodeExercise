class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        int len = nums.length;
        for ( int i = 0; i < len; i++ ){
            diff ^= nums[i];
        }
        // XOR to get the whole different bits
        // 2's implements to get the right most bit
        diff &= -diff;
        int[] ret = new int[2];
        for( int i = 0; i < len; i++ ){
            if( (diff & nums[i]) == 0 ){
                ret[0] ^= nums[i];
            } // the first different num
            else {
                // skip one of the numbers and xor the whole will get the other, like Single Number
                ret[1] ^= nums[i]; 
            }
        }
        return ret;
        
    }
}
