class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // check param
        if ( nums == null || nums.length == 0 || k <= 0 ) return false;
        int sum = 0;
        for ( int num : nums ) {
            sum += num;
        }
        if ( sum % k != 0 ) return false;
        // System.out.printf("target = %d\n", sum/k);
        Arrays.sort(nums);
        int idx = nums.length - 1;
        int target = sum/k;
        if ( nums[idx] > target ) return false;
        while ( idx >= 0 && nums[idx] == target ) {
            idx--;
            k--;
        }
        return dfs(nums, idx, new int[k], target);
        
    }
    public boolean dfs(int[] nums, int idx, int[] buckets, int target) {
        // put every num into corresponding bucket
        // System.out.printf("idx = %d\n", idx);
        if ( idx < 0 ) return true;
        int num = nums[idx];
        for ( int i = 0; i < buckets.length; i++ ) {
            if ( buckets[i] + num <= target ) {
                buckets[i] += num;
                if ( dfs(nums, idx - 1, buckets, target) ) return true;
                buckets[i] -= num;
            }
            // if bucket value return to 0, no need to dfs.
            if ( buckets[i] == 0 ) break;
        }
        return false;
    }
}
