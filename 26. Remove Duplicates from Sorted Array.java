/*
Because of duplicate numbers, the space storing those duplicates are invalid and can be used to store other nums.
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        if( nums == null ) return 0;
        int idx = 0;
        int len = nums.length;
        for( int i = 0; i < len; i++ ){
            if( i == len - 1 || nums[i] != nums[i+1] ){
                nums[idx] = nums[i];
                idx++;
            }
        }
        return idx;
    }
}
