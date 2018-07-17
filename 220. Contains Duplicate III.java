class Solution {
    /* Two ways: 
     * 1. straightforward way:
     * loop through every one's range in k and check whether dif is in t.
     * Time  complexity : O(k*n);
     * Space complexity : O(1);
     * 2. HashMap way
     * 
     * Time  complexity : O(n);
     * Space complexity : O(n);
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // check param
        if ( nums == null || nums.length == 0 || k < 1 || t < 0 ) return false;
        
        HashMap<Long, Long> map = new HashMap<>();
        for ( int i = 0; i < nums.length; i++ ) {
            long num = (long)nums[i] - Integer.MIN_VALUE;
            long bucket = num / ((long)t + 1);
            if ( map.containsKey(bucket) 
                || (map.containsKey(bucket + 1) && map.get(bucket + 1) - num <= t ) 
                || (map.containsKey(bucket - 1) && num - map.get(bucket - 1) <= t ) )
                return true;
            if ( map.size() >= k ) {
                long lastBucket = ((long)nums[i - k] - Integer.MIN_VALUE) / ((long)t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, num);
        }
        return false;
    }
}
