/*
This problem has many different solutions, and the following two is the easiest to understand
*/
class Solution {
    public void sortColors(int[] nums) {
        if ( nums == null || nums.length == 0 ) return;
        int len = nums.length;
        int n0 = 0;
        int n2 = len - 1;
        for ( int i = 0; i <= n2; i++ ){
            if ( nums[i] == 0 ) {
                nums[i] = nums[n0];
                nums[n0++] = 0;
            }
            if ( nums[i] == 2 ) {
                nums[i] = nums[n2];
                nums[n2--] = 2;
                i--;
            }
        }
    }
}

/*
Insertion solution
Explanation: restore the last index of 0, 1, 2 and when it comes a new num, we insert it and increment the corresponding index, eg insert 0, increase index of 0,1,2 but if insert 2 we only need to increase the index of 2.
n0,n1,n2
for( i from 0 to nums.length){
    if nums[i] = 0
        nums[++n2] = 2;
        nums[++n1] = 1;
        nums[++n0] = 0
    else if
    else 
}
*/
