class Solution {
    public List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if ( target < 0 || target > 45 ) return res;
        List<Integer> pre = new ArrayList<Integer>();
        backtrack(pre, k, 1, 10, target, 0, res);
        return res;
    }
    public void backtrack(List<Integer> pre, int num, int index, int n, int target, int sum, List<List<Integer>> res){
        if( sum == target && pre.size() == num){
            res.add(new ArrayList<Integer>(pre) );
            return;
        }
        else if ( pre.size() > num ) return;
        else{
            for ( int i = index; i < n; i++ ){
                sum += i;
                if( sum > target ) return;
                pre.add(i);
                backtrack(pre, num, i+1, n, target, sum, res);
                pre.remove(pre.size() - 1);
                sum -= i;
            }
        }
    }
}
