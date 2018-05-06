class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if ( nums == null || nums.length == 0 ) return 0;
        int sum = 0;
        int minlen = Integer.MAX_VALUE;
        for ( int i = 0, j = 0; j <= nums.length; ){
            if ( sum >= s ) {
                minlen = Math.min(minlen, j-i);
                sum -= nums[i++];
                
            }
            else{
                if ( j == nums.length ) break;
                sum += nums[j];
                j++;
            }
        }
        return minlen == Integer.MAX_VALUE ? 0 : minlen;
    }
}
