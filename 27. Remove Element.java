/*
delnum is used to identify the number of deleted elements in nums[]
*/
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null) return -1;
        int len = nums.length;
        int delnum = 0;
        for ( int i = 0; i < len; i++){
            if( nums[i] != val ){
                nums[i - delnum] = nums[i];
            }
            else{
                delnum++;
            }
        }
        return len - delnum;
    }
}
