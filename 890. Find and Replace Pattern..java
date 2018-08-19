class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        
        for ( String word : words ) {
            if ( word.length() != pattern.length() ) continue;
            HashMap<Character, Character> map = new HashMap<>();
            // HashMap<Cha
            boolean isFound = true;
            for ( int i = 0; i < word.length() ; i++ ) {
                if ( !map.containsKey(word.charAt(i)) && !map.containsValue(pattern.charAt(i)) ) {
                    map.put(word.charAt(i), pattern.charAt(i));
                }
                else if ( !map.containsKey(word.charAt(i)) || map.get(word.charAt(i)) != pattern.charAt(i) ) {
                    isFound = false;
                    break;
                }
            }
            if ( isFound ) {
                res.add(word);
            }
        }
        return res;
    }
}
