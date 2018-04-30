class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if ( nums == null ) return null;
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(new ArrayList<Integer>(), nums, used, res);
        return res;
    }
    public void backtrack(List<Integer> pre, int[] nums, boolean[] used, List<List<Integer>> res){
        if( pre.size() == nums.length ) {
            res.add( new ArrayList<Integer>(pre) );
        }
        else{
            for ( int i = 0; i < nums.length; i++){
                if ( used[i] ) continue;
                if ( i > 0 && nums[i] == nums[i-1] && !used[i-1] ) continue; // if smaller not used, larger will not used.
                used[i] = true;
                pre.add(nums[i]);
                backtrack(pre, nums, used, res);
                used[i] = false;
                pre.remove(pre.size() - 1);
            }
        }
    }
}
