// it is very smart to make use of remainder.
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // so brilliant to get remainder
        if ( nums == null || nums.length == 0 ) return false;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for ( int i = 0; i < nums.length; i++ ) {
            sum += nums[i];
            if ( k != 0 ) sum = sum % k;
            if ( map.containsKey(sum) ) {
                int pre = map.get(sum);
                if ( i - pre > 1 ) return true;
            }
            else {
                map.put(sum, i);
            }
        }
        return false;
    }
}
