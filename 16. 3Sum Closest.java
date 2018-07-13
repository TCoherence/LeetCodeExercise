class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // check para
        
        //
        Arrays.sort(nums);
        int curSum = 0;
        int curDif = Integer.MAX_VALUE;
        for ( int i = 0; i < nums.length - 2; i++ ) {
            int l = i + 1;
            int r = nums.length - 1;
            while ( l < r ) {
                int dif = nums[i] + nums[l] + nums[r] - target;
                if ( Math.abs(dif) < curDif  ) {
                    curDif = Math.abs(dif);
                    curSum = dif + target; 
                    // while( l < r && nums[l] == nums[l + 1]) l++;
                    // while( l < r && nums[r - 1] == nums[r]) r--;
                    // l++;
                    // r--;
                }
                if ( dif <= 0 ) l++;
                else r--;
            }          
        }
        return curSum;
        
        
    }
}
