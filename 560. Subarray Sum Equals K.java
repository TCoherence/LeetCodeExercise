class Solution {
    public int subarraySum(int[] nums, int k) {
        // check para
        if ( nums == null || nums.length == 0 ) return 0;
        
        int  cnt = 0;
        long sum = 0;
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put((long)0, 1);
        for ( int i = 0; i < nums.length; i++ ) {
            sum += nums[i];
            if ( map.containsKey(sum - k) ){
                cnt += map.get(sum - k);
            }
            map.put( sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}
