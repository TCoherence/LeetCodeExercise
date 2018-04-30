class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if ( candidates == null || candidates.length == 0 ) return res;
        List<Integer> pre = new ArrayList<Integer>();
        Arrays.sort(candidates);
        backtrack(pre, 0, candidates, target, 0, res, new boolean[candidates.length]);
        return res;
    }
    public void backtrack(List<Integer> pre, int index, int[] candidates, int target, int sum, List<List<Integer>> res, boolean[] used){
        if( sum > target) return; 
        if( sum == target ){
                res.add(new ArrayList<Integer>( pre ));
                return;
            }
        for ( int i = index; i < candidates.length; i++ ){
            if ( i > 0 && candidates[i] == candidates[i-1] && !used[i-1] ) continue;
            used[i] = true;
            sum += candidates[i];
            pre.add(candidates[i]);
            backtrack( pre, i+1, candidates, target, sum, res, used);
            pre.remove(pre.size() - 1);
            sum -= candidates[i];
            used[i] = false;
        }// for loop end;
    }
}
