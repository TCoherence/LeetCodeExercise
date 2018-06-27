class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        // get the depth of this triangle and build dp array, depth == the last list.size
        int[] res = new int[triangle.size() + 1];
        
        // classic dp ops
        for ( int i = triangle.size() - 1; i >= 0; i-- ) {
            for ( int j = 0; j < triangle.get(i).size(); j++ ) {
                res[j] = Math.min(res[j], res[j + 1]) + triangle.get(i).get(j);
            }
        }
        
        // return
        return res[0];
        
    }
}
