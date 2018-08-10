class Solution {
    public boolean containsDuplicate(int[] nums) {
        if ( nums ==  null || nums.length == 0 ) return false;
        
        int len = nums.length;
        Arrays.sort(nums);
        for( int i = 0; i < len - 1; i++ ){
            if ( nums[i] == nums[i+1] ) return true;
        }
        return false;
    }
}
