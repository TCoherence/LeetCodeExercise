class Solution {
    public void nextPermutation(int[] nums) {
        if ( nums == null || nums.length == 0 || nums.length == 1) return ;
        int len = nums.length;
        // find the point
        int index = 0;
        for ( int i = len - 1; i >= 0; i-- ){
            if ( i > 0 && nums[i] <= nums[i - 1]) continue;
            index = i;
            break;
        }
        // turn over
        for ( int start = index, end = len - 1; start < end ; ){
            int swap = nums[start];
            nums[start] = nums[end];
            nums[end] = swap;
            start++;
            end--;
        }
        if ( index == 0 ) return;
        int i = index;
        while (nums[index-1] >= nums[i]) { i++; }
        int swap = nums[i];
        nums[i] = nums[index - 1];
        nums[index - 1] = swap;
        
    }
}
