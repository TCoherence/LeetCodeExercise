class Solution {
    public List<List<Integer>> combine(int n, int k) {
        // some corner cases
        if ( n < k ) return null;
        
        List<Integer> pre = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack( pre, 1, n+1, k, res);
        return res;
    }
    public void backtrack(List<Integer> pre, int index, int n, int k, List<List<Integer>> res){
        if( pre.size() == k ){
            res.add( new ArrayList<Integer>(pre) );
            return;
        }
        else {
            for ( int i = index; i < n; i++ ){
                pre.add(i);
                backtrack(pre, i+1, n, k, res);
                pre.remove(pre.size() - 1);
            }
        }
    }
}
