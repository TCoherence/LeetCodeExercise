class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        // check param
        if ( cpdomains == null || cpdomains.length == 0 ) return new ArrayList<String>();
        
        HashMap<String, Integer> map = new HashMap<>();
        for ( String cpdomain : cpdomains ) {
            int i = cpdomain.indexOf(' ');
            int time = Integer.valueOf(cpdomain.substring(0, i));
            String str = cpdomain.substring(i + 1);
            map.put(str, map.getOrDefault(str, 0) + time);
            for ( i = 0; i < cpdomain.length(); i++ ) {
                if ( cpdomain.charAt(i) == '.' ) {
                    String substr = cpdomain.substring(i + 1);
                    map.put(substr, map.getOrDefault(substr, 0) + time);
                }
            }
            
        }
        List<String> res = new ArrayList<>();
        for ( Map.Entry<String, Integer> o : map.entrySet() ) {
            String tmp = o.getValue() + " " + o.getKey();
            res.add(tmp);
        }
        return res;
    }
}
