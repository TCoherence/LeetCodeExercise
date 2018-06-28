class Solution {
    public List<List<Integer>> generate(int numRows) {
        // check para
        
        // build two var:
        // List<List<Integet>> res = 
        // List<Integer> list = 
        // when put list into res, list need to be renewed.
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        
        for ( int i = 1; i <= numRows; i++ ) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++ ) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
            res.add(new ArrayList(list));
        }
        return res;
    }
}

