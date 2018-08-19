class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> map = new HashMap<>();
        // build union-find connections
        for( List<String> account : accounts ) {
            String name = account.get(0);;
            for ( int i = 1; i < account.size(); i++ ) {
                if ( !map.containsKey(account.get(i)) )
                    map.put(account.get(i), new HashSet<>());
                map.get(account.get(i)).add(account.get(1));
                map.get(account.get(1)).add(account.get(i));
            }
        }
        Set<String> visited = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        for ( List<String> acc : accounts ) {
            List<String> list = new ArrayList<>();
            if ( !visited.contains(acc.get(1)) ) {
                bfs(visited, map, list, acc.get(1));
                Collections.sort(list);     // sort
                list.add(0, acc.get(0));    // add name
                res.add(list);
            }
        }
        return res;
    }
    public void bfs(Set<String> visited, Map<String, Set<String>> map, List<String> list, String node) {
        Queue<String> q = new LinkedList<>();
        q.offer(node);
        visited.add(node);
        while ( !q.isEmpty() ) {
            String parent = q.poll();
            list.add(parent);
            for ( String child : map.get(parent) ) {
                if ( !visited.contains(child) ) {
                    q.offer(child);
                    visited.add(child);
                }
            }
        }
    }
}
