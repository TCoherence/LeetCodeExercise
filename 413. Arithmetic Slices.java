class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if ( nums == null || nums.length < 3 ) return 0;
        int[] slices = new int[nums.length+1];
        // slices[0] = 0;
        // slices[1] = 0;
        // slices[2] = 0;
        slices[3] = 1;
        for ( int i = 4; i < slices.length; i++ ){
            slices[i] = slices[i-1]  + i - 2;
        }
        int count = 1;
        int ret = 0;
        int constDiff = nums[1] - nums[0];
        for ( int i = 1; i < nums.length; i++ ){
            if ( nums[i] - nums[i-1] == constDiff ) {
                count++;
                continue;
            }
            constDiff = nums[i] - nums[i - 1];
            ret += slices[count];
            count = 2;
        }
        if ( count != 1 ) ret += slices[count];
        return ret;
        
    }
}
