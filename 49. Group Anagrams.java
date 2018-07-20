class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // check param
        if ( strs == null || strs.length == 0 ) return new ArrayList<List<String>>();
        
        // the key is how to generate a probable HashKey
        // List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<>();
        for ( String s : strs ) {
            char[] str = s.toCharArray();
            String key = getKey(str);
            if ( !map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        // get list value from map
        return new ArrayList<List<String>>(map.values()); 
        
        // return
        // return res;
    }
    public String getKey(char[] str) {
        int[] ret = new int[26];
        for ( int i = 0; i < str.length; i++ ) {
            ret[str[i] - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < ret.length; i++ ) {
            while ( ret[i]-- > 0 ) {
                sb.append('a' + i);
            }
        }
        return sb.toString();
    }
}
