class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // check param
        if ( nums == null || nums.length == 0 ) return 0;
        
        int i = 0, j = 0;
        int pro = 1;
        int count = 0;
        
        while ( j < nums.length ) {
            pro *= nums[j];
            while ( pro >= k && i <= j ) {
                count += j - i;
                pro /= nums[i];
                i++;
            }
            j++;
        }
        long num = (long)j - i;
        num = count + (num + 1) * num / 2;
        count = (int) num;
        
        return count;
    }
}
