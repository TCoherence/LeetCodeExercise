class Solution {
    public String minWindow(String s, String t) {
        // check para
        if ( s == null || t == null ) return "";
        
        int lenOfT = t.length();
        int lenOfS = s.length();
        int begin = 0, end = 0;
        int counter = 0;
        int minLen = Integer.MAX_VALUE, len = Integer.MAX_VALUE;
        String minStr = "";
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for ( char c : t.toCharArray() ) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        counter = map.size();
        
        while ( end < lenOfS ) {
            char c1 = s.charAt(end);
            if ( map.containsKey(c1) ){
                map.put(c1, map.get(c1) - 1);
                if ( map.get(c1) == 0 ) counter--;
            }
            end++;
            while ( counter == 0 ) {
                char c2 = s.charAt(begin);
                if ( map.containsKey(c2) ) {
                    map.put(c2, map.get(c2) + 1);
                    if ( map.get(c2) > 0 ) counter++;
                }
                if ( counter != 0 ) {
                    len = end - begin;
                    if ( len < minLen ) {
                        minLen = len;
                        minStr = s.substring(begin, end);
                    }
                }
                begin++;
            }
        }
        return minStr;
    }
}
