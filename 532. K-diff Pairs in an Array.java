class Solution {
    public int findPairs(int[] nums, int k) {
        if(k < 0) return 0;
        int ans = 0;
        Arrays.sort(nums);
        for(int i = 0, j = 1; j < nums.length;  ){
            if(i >= j || nums[i] + k > nums[j]) j++;
            else if( i > 0 && nums[i] == nums[i - 1] || nums[i] + k < nums[j]) i++;
            else{
                ans++; i++;
            }
        }
        return ans;
    }
}
