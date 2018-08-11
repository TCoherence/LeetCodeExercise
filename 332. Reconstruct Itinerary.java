class Solution {
    private Map<String, PriorityQueue<String>> map = new HashMap<>();
    private List<String> res = new LinkedList<>();
    public List<String> findItinerary(String[][] tickets) {     
        for ( String[] ticket : tickets ) {
            if ( !map.containsKey(ticket[0]) ) 
                map.put(ticket[0], new PriorityQueue<>());
            map.get(ticket[0]).add(ticket[1]);
        }
        visit("JFK");
        return res;
    }
    public void visit(String ticket) {
        while ( map.containsKey(ticket) && !map.get(ticket).isEmpty() )
            visit(map.get(ticket).poll());
        res.add(0, ticket);
    }
}
