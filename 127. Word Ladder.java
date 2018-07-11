/* one-end to bfs.
 * two-end to bfs will be better.
 * 
 * 
 */

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>();
        // change List to HashSet
        for ( int i = 0; i < wordList.size(); i++ ) {
            dict.add(wordList.get(i));
        }
        
              
        Queue<String> toVisit = new LinkedList<>();
        toVisit.offer(beginWord);
        addNextWord(beginWord, dict, toVisit);
        int dist = 2;
        while( !toVisit.isEmpty() ) {
            int size = toVisit.size();
            for ( int i = 0; i < size; i++ ) {
                String word = toVisit.poll();
                if ( word.equals(endWord) ) return dist;
                addNextWord(word, dict, toVisit);
            }
            dist++;
        }
        // fail to find
        return 0;
    }
    
    public void addNextWord(String word, HashSet<String> dict, Queue<String> toVisit) {
        // change every char of word to see if there are some words in dict will match word.
        // if there are, add them to toVisit
        dict.remove(word);
        char[] str = word.toCharArray();
        for ( int i = 0; i < str.length; i++ ) {
            char letter = str[i];
            for ( char j = 'a'; j <= 'z'; j++ ){
                str[i] = j;
                String w = String.valueOf(str);
                if ( dict.contains(w) ) 
                    toVisit.offer(w);
            }
            str[i] = letter;
        }
    }
}
