class Solution {
    public int firstUniqChar(String s) {
        // check para
        if ( s == null || s.equals("") ) return -1;
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for ( char c : s.toCharArray() ) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int i = 0;
        while ( i < s.length() && map.get(s.charAt(i)) > 1 ) 
            i++;
        return i < s.length() ? i : -1;
    }
}
