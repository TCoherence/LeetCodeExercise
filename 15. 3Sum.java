class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // check para
        if ( nums == null || nums.length == 0 ) return new ArrayList<List<Integer>>();
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        
        Arrays.sort(nums);
        for ( int i = 0; i < nums.length - 2; i++ ) {
            if ( i == 0 || nums[i] != nums[i-1]){
                int l = i + 1;
                int r = nums.length - 1;
                while ( l < r ) {
                    if ( nums[l] + nums[r] + nums[i] == 0 ) {
                        list.add(nums[i]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        res.add(list);
                        list = new ArrayList<>();
                        while ( l < r && nums[l] == nums[l + 1] ) l++;
                        while ( r > l && nums[r] == nums[r - 1] ) r--;
                        l++;
                        r--;
                    }
                    else if ( nums[l] + nums[r] + nums[i] < 0 )
                        l++;
                    else
                        r--;
                }
            }
        }
        return res;
    }
}
