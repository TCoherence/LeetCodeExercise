class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if ( nums == null || nums.length == 0) {
            List<Integer> tmp = new ArrayList<Integer>();
            res.add(tmp);
            return res;
        }
        List<Integer> lastres = new ArrayList<Integer>();
        backtrack(lastres, nums, res);
        return res;
    }
    public void backtrack( List<Integer> lastres, int[] nums, List<List<Integer>> res ){
        if ( lastres.size() < nums.length ){
            for ( int i = 0; i < nums.length; i++){
                if( lastres.contains(nums[i]) ) continue;
                lastres.add(nums[i]);
                backtrack(lastres, nums, res);
                lastres.remove(lastres.size() - 1);
            }
        }
        else{
            res.add(new ArrayList(lastres));
            return;
        }
    }
}
