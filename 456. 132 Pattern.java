class Solution {
    public boolean find132pattern(int[] nums) {
        // check param
        if ( nums == null || nums.length <= 2 ) return false;
        
        int len = nums.length;
        int[] lessThan = new int[len];
        lessThan[0] = nums[0];
        for ( int i = 1; i < len - 1; i++ ) {
            lessThan[i] = Math.min(lessThan[i - 1], nums[i]);
        }
        int k = len - 1;
        lessThan[k] = nums[k];
        for ( int j = len - 2; j >= 1; j-- ) {
            if ( nums[j] <= lessThan[j] ) continue;     // j > i
            while ( k < len && lessThan[k] <= lessThan[j] ) k++;
            if ( k < len && lessThan[k] < nums[j] ) return true;
            k--;
            lessThan[k] = nums[j];
        }
        return false;
    }
}
