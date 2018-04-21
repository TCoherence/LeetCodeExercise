class Solution {
    public String countAndSay(int n) {
        if ( n <= 0 ) return "1";
        if ( n == 1 ) return "1";
        String s = "1";
        for ( int i = 1; i < n; i++ ){
            s = countandsay(s);
        }
        return s;
    }
    
    public String countandsay(String s){
        char[] str = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for( int i = 0; i < str.length; i++ ){
            if( i == str.length - 1 || str[i] != str[i + 1] ){
                sb.append(count);
                sb.append(str[i]);
                count = 1;
            }
            else count++;
        }
        return sb.toString();
    }
}

//String和StringBuilder特性决定了操作速度。
//





        // old solution，bad performance
        // // if ( n == 2 ) return "11";
        // // if ( n == 3 ) return "21";
        // // if ( n == 4 ) return "1211";
        // // if ( n == 5 ) return "111221";
        // String s = countAndSay(n-1);
        // int len = s.length();
        // int count = 1;
        // String ret = "";
        // for ( int i = 0; i < len - 1; i++ ){
        //     if( s.charAt(i) == s.charAt(i+1) ){
        //         count++;
        //     }
        //     else{//s.charAt(i) != s.charAt(i+1)
        //         ret = ret + count;
        //         ret = ret + s.charAt(i);
        //         count = 1;
        //     }
        // }
        // ret = ret + count;
        // ret = ret + s.charAt(len - 1);
        // return ret;
