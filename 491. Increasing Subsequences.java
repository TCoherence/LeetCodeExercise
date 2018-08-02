class Solution {
    
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> set = new HashSet<>();
        if ( nums == null || nums.length == 0 ) return res;
        
        for ( int i = 0; i < nums.length; i++ ) {
            list.add(nums[i]);
            dfs(nums, i + 1, list, res, set);
            list.remove(list.size() - 1);
        }
        return res;
    }
    
    public void dfs(int[] nums, int start, List<Integer> list, List<List<Integer>> res, HashSet<List<Integer>> set) {
        if ( nums.length <= start ) {
            if ( set.contains(list) ) return;
            if ( list.size() >= 2 ) {
                set.add(new ArrayList<>(list));
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for ( int i = start; i < nums.length; i++ ) {
            if ( nums[i] >= list.get(list.size() - 1) ) {
                list.add(nums[i]);
                if ( set.contains(list) ) {
                    list.remove(list.size() - 1);
                    continue;
                } 
                set.add(new ArrayList<>(list));
                res.add(new ArrayList<>(list));
                dfs(nums, i + 1, list, res, set);
                list.remove(list.size() - 1);
            }
                        
        }
    }
}
