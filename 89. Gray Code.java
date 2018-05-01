class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        if( n < 0 ) return res;
        backtrack(n, 0, res);
        return res;
    }
    public void backtrack(int n, int size, List<Integer> res){
        if( n == 0 ) {
            res.add(0);
            return;
        }
        else {
            backtrack( n - 1, size, res);
            size = res.size();
            for ( int i = size - 1; i >= 0; i--){
                res.add(res.get(i)+size);
            }
        }
    }
}
