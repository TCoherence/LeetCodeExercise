class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] res = new double[queries.length];
        Map<String, ArrayList<String>> pairs = new HashMap<>();
        Map<String, ArrayList<Double>> valuePairs = new HashMap<>();
        
        // update graph
        for ( int i = 0; i < equations.length; i++ ) {
            String[] eq = equations[i];
            double value = values[i];
            if( !pairs.containsKey(eq[0]) ) {
                pairs.put(eq[0], new ArrayList<String>());
                valuePairs.put(eq[0], new ArrayList<Double>());
            }
            if( !pairs.containsKey(eq[1]) ) {
                pairs.put(eq[1], new ArrayList<String>());
                valuePairs.put(eq[1], new ArrayList<Double>());
            }
            pairs.get(eq[0]).add(eq[1]);
            valuePairs.get(eq[0]).add(value);
            pairs.get(eq[1]).add(eq[0]);
            valuePairs.get(eq[1]).add(1 / value);
        }
        // dfs every query
        for ( int i = 0; i < queries.length; i++ ) {
            double ret = dfs(queries[i][0], queries[i][1], pairs, valuePairs, new HashSet<>(), 1.0);
            if ( ret == 0.0 )
                res[i] = -1.0;
            else
                res[i] = ret;
        }
        return res;
        
    }
    public double dfs(String start, String end, Map<String, ArrayList<String>> pairs, Map<String, ArrayList<Double>> values, Set<String> visited, double value) {
        if ( visited.contains(start) ) return 0.0;
        if ( !pairs.containsKey(start) || !pairs.containsKey(end) ) return 0.0;
        if ( start.equals(end) ) return value;
        
        visited.add(start);
        double ret = 0.0;
        for ( int i = 0; i < pairs.get(start).size(); i++ ) {
            String next = pairs.get(start).get(i);
            ret = dfs(next, end, pairs, values, visited, value * values.get(start).get(i));
            if ( ret != 0.0 )
                break;
        }
        return ret;
    }
}
