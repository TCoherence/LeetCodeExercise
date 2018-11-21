class Solution {
    // dynamic alter arraylist size
    public List<Integer> partitionLabels(String S) {
        if ( S == null || S.length() == 0 ) return new ArrayList<>();
        
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for ( int i = 0; i < S.length(); i++ ) {
            if ( !map.containsKey(S.charAt(i)) ) {
                map.put(S.charAt(i), i);
                res.add(1);
            }
            else {
                int curIdx = i;
                int last = map.get(S.charAt(i));
                int tmp = 1;
                while ( last < curIdx ) {
                    int length = res.size();        
                    tmp += res.get(length - 1);
                    curIdx -= res.get(length - 1);
                    res.remove(length - 1);
                }
                res.add(tmp);
                map.put(S.charAt(i), i);
            }
        }
        return res;
    }
    
    // two loop solution, using map
    public List<Integer> partitionLabels(String S) {
        if ( S == null || S.length() == 0 ) return new ArrayList<>();
        
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for ( int i = 0; i < S.length(); i++ ) {
            map.put(S.charAt(i), i);
        }
        int start = 0, end = 0;
        for ( int i = 0; i < S.length(); i++ ) {
            end = Math.max(end, map.get(S.charAt(i)));
            if ( i == end ) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
    
    // two loop solution, using array
    public List<Integer> partitionLabels(String S) {
        if ( S == null || S.length() == 0 ) return new ArrayList<>();
        
        List<Integer> res = new ArrayList<>();
        int[] lastIndexOf = new int[26];
        for ( int i = 0; i < S.length(); i++ ) {
            lastIndexOf[S.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        for ( int i = 0; i < S.length(); i++ ) {
            end = Math.max(end, lastIndexOf[S.charAt(i) - 'a']);
            if ( i == end ) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}
