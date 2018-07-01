class Solution {
    public int maxProduct(int[] nums) {
        // check para
        if (nums == null || nums.length == 0) throw new java.lang.NullPointerException("Null pointer or empty array detected...");
        
        // DP solution
        // local_max, local_min, global_max
        // local_max = max(local_max * nums[i], nums[i])
        // 
        int localMax = nums[0];
        int localMin = nums[0];
        int globalMax = nums[0];
        for ( int i = 1; i < nums.length; i++ ){
            // if nums[i] < 0, we need swap localMax and localMin to make sure that 
            // localMin will be the maximum when it comes to another negative number
            if ( nums[i] < 0 ){
                int tmp = localMin;
                localMin = localMax;
                localMax = tmp;
            }
            
            localMax = Math.max(localMax * nums[i], nums[i]);
            localMin = Math.min(localMin * nums[i], nums[i]);
            globalMax = Math.max(localMax, globalMax);
        }
        // return result
        return globalMax;
        
    }
}
