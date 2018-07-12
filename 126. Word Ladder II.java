class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);
        HashSet<String> visited = new HashSet<>();
        if ( !dict.contains(endWord) ) return new ArrayList<List<String>>();
        
        
        
        List<List<String>> res = new ArrayList<List<String>>();     // used to return      
        List<String> list = new ArrayList<>();                      // used in dfs
        Queue<String> toVisit = new LinkedList<>();                 // used in bfs 
        HashMap<String, Integer> dist =                             // distance from curWord to beginWord
            new HashMap<String, Integer>();
        HashMap<String, List<String>> neighborWord =                
            new HashMap<String, List<String>>();                    // store every word's neighbors(only next-L),  
                                                                    // initialised in bfs and will be used in dfs
        for ( String str : dict ) 
            neighborWord.put( str, new ArrayList<String>() );       // init neighborWord
        neighborWord.put( beginWord, new ArrayList<String>() );     // 
        
        for ( String str : dict ) 
            dist.put( str, 0 );
        dist.put( beginWord, 0 );
        
        // bfs to find minDistance;
        toVisit.offer(beginWord);
        if ( dict.contains(beginWord) ) dict.remove(beginWord);
        int curMin = 1;

        while( !toVisit.isEmpty()  ) {
            int size = toVisit.size();
            boolean isFind = false;
            for ( int k = 0; k < size; k++ ) {
                String word = toVisit.poll();
                dist.put(word, curMin - 1);
                if ( word.equals(endWord) ) {
                    isFind = true;
                    break;                    
                }
                dict.remove(word);

                char[] str = word.toCharArray();
                for ( int i = 0; i < word.length(); i++ ) {
                    char letter = str[i];
                    for ( char j = 'a'; j <= 'z'; j++ ) {
                        str[i] = j;
                        String w = String.valueOf(str);                        
                        if ( dict.contains(w) /*&& !visited.contains(w)*/ ){
                            if ( !visited.contains(w) ) {
                                toVisit.offer(w);
                                visited.add(w);
                            }
                            neighborWord.get(word).add(w);
                        }
                    }
                    str[i] = letter;
                }
            }
            if ( isFind ) 
                break;
            else
                curMin++;
        }
        
        // dfs to record every possible ways
        list.add(beginWord);
        //visited = new HashSet<String>();
        dfs(1, curMin, beginWord, endWord, neighborWord, dist, list, res);
        // return 
        return res;
    }
    
    private void dfs(int len, int min, String word, String endWord, HashMap<String, List<String>> neighborWord, 
                     HashMap<String, Integer> dist, List<String> list, List<List<String>> res ) {
        
        
        // find one, put it into res.
        if ( len > min ) return;
        if ( len == min && word.equals(endWord) ) {
            res.add(new ArrayList<String>(list) );
            return;
        }
        len++;
        // curWord, search every neighbirWord and record(update) them to list, visited.
        for ( String w : neighborWord.get(word) ) {
            list.add(w);
            //visited.add(word);
            // go deeper
            if ( dist.get(word) == dist.get(w) - 1 ) dfs(len, min, w, endWord, neighborWord, dist, list, res);
            // back, update list visited.
            list.remove(w);
            //visited.remove(word);
        }
        
    }
}
