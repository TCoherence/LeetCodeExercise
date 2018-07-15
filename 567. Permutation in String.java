class Solution {
    public boolean checkInclusion(String s2, String s1) {
        // check para
        if ( s1 == null || s2 == null ) return false;
        
        int len1 = s1.length();
        int len2 = s2.length();
        int begin = 0, end = 0;
        int counter = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for ( char c : s2.toCharArray() ) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        counter = map.size();
        
        
        while ( end < len1 ) {
            char endChar = s1.charAt(end);
            if ( map.containsKey(endChar) ) {
                map.put(endChar, map.get(endChar) - 1);
                if ( map.get(endChar) == 0 ) 
                    counter--;
            }
            end++;
            
            while ( counter == 0 ) {
                char beginChar = s1.charAt(begin);
                if ( map.containsKey(beginChar) ) {
                    map.put(beginChar, map.get(beginChar) + 1);
                    if ( map.get(beginChar) > 0 ) 
                        counter++;
                }
                if ( end - begin == len2 ) return true;
                begin++;
            }
        }
        return false;
    }
}
