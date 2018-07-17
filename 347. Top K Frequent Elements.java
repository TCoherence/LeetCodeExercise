class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // check para
        if ( k <= 0 || nums == null || nums.length == 0 ) throw new java.lang.IllegalArgumentException();
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // count freq
        for ( int i : nums ) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // sort freq
        List<Integer> [] sortedFreq = new List[nums.length + 1];
        for ( int i : map.keySet() ) {
            int freq = map.get(i);
            if ( sortedFreq[freq] == null ) 
                sortedFreq[freq] = new ArrayList<>();
            sortedFreq[freq].add(i);
        }
        
        List<Integer> res = new ArrayList<>();
        for ( int i = sortedFreq.length - 1; i >= 0 && k > 0; i-- ) {
            if ( sortedFreq[i] != null ) {
                res.addAll(sortedFreq[i]);
                k -= sortedFreq[i].size();
            }
        }
        return res;
        
    }
}
