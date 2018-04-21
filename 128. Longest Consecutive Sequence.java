class Solution {
    public int longestConsecutive(int[] nums) {
        if( nums == null || nums.length == 0) return 0;
        
        int len = nums.length;
        Arrays.sort(nums);
        int max = 1;
        int maxinloop = 1;
        for( int i = 0; i < len - 1; i++){
            //Consecutive
            if(nums[i] + 1 == nums[i+1]){
                maxinloop++;
                
            }
            //Duplicate
            else if (nums[i] == nums[i+1]) {
                continue;
            }
            //Broken
            else{
                max = Math.max(max,maxinloop);
                maxinloop = 1;
            }
        }
        max = Math.max(max,maxinloop);
        return max;
    }
}
