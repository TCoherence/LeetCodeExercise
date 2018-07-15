class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // check para
        if ( s == null || p == null || s.equals(null) || p.equals(null) ) return new ArrayList<Integer>();

        int lenOfS = s.length();
        int lenOfP = p.length();
        int begin = 0, end = 0;
        int counter = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for ( char c : p.toCharArray() ) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        counter = map.size();
        List<Integer> res = new ArrayList<Integer>();
        while ( end < lenOfS ) {
            char endChar = s.charAt(end);
            if ( map.containsKey(endChar) ) {
                map.put(endChar, map.get(endChar) - 1);
                if ( map.get(endChar) == 0 ) counter--;
            }
            end++;
            
            while ( counter == 0 ) {
                char beginChar = s.charAt(begin);
                if ( map.containsKey(beginChar) ) {
                    map.put(beginChar, map.get(beginChar) + 1);
                    if ( map.get(beginChar) > 0 ) 
                        counter++;
                }
                
                if ( end - begin == lenOfP ) {
                    res.add(begin);
                }
                begin++;
            }
        }
        return res;
    }
}
