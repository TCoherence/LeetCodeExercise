class Solution {
    public int removeDuplicates(int[] nums) {
        if ( nums == null || nums.length == 0 ) return 0;
        if ( nums.length == 1 ) return 1;
        if ( nums.length == 2 ) return 2;
        int numOfDel = 0;
        int count = 1;
        for ( int i = 1; i < nums.length; i++ ){
            if ( nums[i-1] == nums[i] ){
                if ( count >= 2 ) {
                    numOfDel++;
                }
                count++;
            }
            else{
                count = 1;
            }
            nums[i-numOfDel] = nums[i];
        }
        return nums.length - numOfDel;
    }
}
