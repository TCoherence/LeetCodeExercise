class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if ( nums == null ) return null;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(new ArrayList<Integer>(), nums, 0, res);
        return res;
    }
    public void backtrack(List<Integer> pre, int[] nums, int index, List<List<Integer>> res){
        // if ( pre.size() == nums.length ) {
        //     res.add( new ArrayList<Integer>(pre) );
        //     return;
        // }
        // else{
            res.add( new ArrayList<Integer>(pre) );
            for ( int i = index; i < nums.length; i++ ) {
                pre.add(nums[i]);
                backtrack(pre, nums, i+1, res);
                pre.remove(pre.size() - 1);
            }
        // }
    }
}
