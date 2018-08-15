class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        if ( words == null || words.length == 0 ) return new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        HashMap<String, Integer> dict = new HashMap<>();
        for ( int i = 0; i < words.length; i++ ) {
            dict.put(words[i], i);
        }
        // check "" --> 1. isExist 2. other is self-palindrome
        if ( dict.containsKey("") ) {
            int blankIdx = dict.get("");
            for ( int i = 0; i < words.length; i++ ) {
                if ( i != blankIdx && isPalindrome(words[i]) ) {
                    res.add(Arrays.asList(i, blankIdx));
                    res.add(Arrays.asList(blankIdx, i));
                }
            }
        }
            
        // check reverse
        for ( int i = 0; i < words.length; i++ ) {
            String wordReverse = reverseWord(words[i]);
            if ( dict.containsKey(wordReverse) ) {
                int other = dict.get(wordReverse);
                if ( i == other ) continue; // self palindrome, pass
                res.add( Arrays.asList(i, other) );
                // res.add( Arrays.asList(dict.get(wordReverse), i) );
            }
        }
        // check prefix or suffix
        for ( int i = 0; i < words.length; i++ ) {
            String word = words[i];
            for ( int cut = 1; cut < word.length(); cut++ ) {
                // prefix
                String prefixRe = reverseWord(word.substring(0, cut));
                if ( dict.containsKey(prefixRe) ) {
                    if ( isPalindrome(word.substring(cut)) ) {
                        res.add( Arrays.asList(i, dict.get(prefixRe)) );
                    }
                }
                
                // suffix
                String suffixRe = reverseWord(word.substring(cut));
                if ( dict.containsKey(suffixRe) ) {
                    if ( isPalindrome(word.substring(0, cut)) ) {
                        res.add( Arrays.asList(dict.get(suffixRe), i) );
                    }
                }
            }
        }
        return res;
    
    }
    public String reverseWord(String word) {
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString();
    }
    
    public boolean isPalindrome(String word) {
        char[] str = word.toCharArray();
        int lo = 0, hi = str.length - 1;
        while ( lo < hi && str[lo] == str[hi]) {
            lo++;
            hi--;
        }
        return lo >= hi ? true : false;
    }
}
