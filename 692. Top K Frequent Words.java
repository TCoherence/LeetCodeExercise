class Solution {
    /* It is really the first time to see someone to use Object as the element of PriorityQueue */
    public List<String> topKFrequent(String[] words, int k) {
        // check param
        if ( words == null || words.length == 0 ) return new ArrayList<String>();
        
        HashMap<String, Integer> map = new HashMap<>();
        for ( String word : words ) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() == o2.getValue() ? o2.getKey().compareTo(o1.getKey()) : o1.getValue() - o2.getValue();
            }
        });
        
        for ( Map.Entry<String, Integer> entry : map.entrySet() ) {
            pq.offer(entry);
            if ( pq.size() > k ) pq.poll();
        }
        
        List<String> res = new ArrayList<String>();
        while ( !pq.isEmpty() ) {
            res.add(pq.poll().getKey());
        }
        Collections.reverse(res);
        return res;
    }
}
