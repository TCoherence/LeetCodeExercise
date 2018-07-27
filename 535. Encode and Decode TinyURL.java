public class Codec {
    private final String    BASE_HOST = "http://tinyurl.com/";
    private final String    SEED = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final int       BASE_HOST_LEN = BASE_HOST.length();
    private final int       SEED_LEN = SEED.length();
    private final int       SHORT_LEN = 6;
    
    private Map<String, String> short2long = new HashMap<>();
    private Map<String, String> long2short = new HashMap<>();
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if ( long2short.containsKey(longUrl) ) {
            return BASE_HOST + long2short.get(longUrl);
        }
        String shortUrl = null;
        do {
            StringBuilder sb = new StringBuilder();
            for ( int i = 0; i < SHORT_LEN; i++ ) {
                int idx = (int)( Math.random() * SEED_LEN );
                sb.append(SEED.charAt(idx));
            }
            shortUrl = sb.toString();
        } while ( short2long.containsKey(shortUrl) );
        short2long.put(shortUrl, longUrl);
        long2short.put(longUrl, shortUrl);
        return BASE_HOST + shortUrl;
        
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return short2long.get(shortUrl.substring(BASE_HOST_LEN));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
