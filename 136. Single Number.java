class Solution {
    public int singleNumber(int[] nums) {
        int tmp = 0;
        for ( int i = 0; i < nums.length; i++){
            tmp = tmp ^ nums[i];
        }
        return tmp;
    }
}
