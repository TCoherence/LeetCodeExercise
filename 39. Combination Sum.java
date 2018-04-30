class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if ( candidates == null || candidates.length == 0 ) return res;
        List<Integer> pre = new ArrayList<Integer>();
        Arrays.sort(candidates);
        backtrack(pre, 0, candidates, target, 0, res);
        return res;
    }
    public void backtrack(List<Integer> pre, int index, int[] candidates, int target, int sum, List<List<Integer>> res){
        if ( sum == target ) {
            res.add(new ArrayList<Integer>(pre));
            return;
        }
        else{
            for ( int i = index; i < candidates.length; i++){
                sum += candidates[i];
                if ( sum > target ) return;
                pre.add(candidates[i]);
                backtrack( pre, i, candidates, target, sum, res);
                pre.remove(pre.size() - 1);
                sum -= candidates[i];
            }
        }
    }
}
