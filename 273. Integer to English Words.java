class Solution {
    private String[] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine","Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",  "Nineteen"};
    private String[] below100 = {"","","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num){
        if ( num == 0 ) return "Zero";
        return func(num);
    }
    public String func( int num ){
        StringBuilder sb = new StringBuilder();
        if( num < 20 ) sb.append( below20[num] );
        else if( num < 100 ){
            sb.append( below100[num/10] );
            if(num%10 != 0) sb.append(" ");
            sb.append( func(num%10) );
        } 
        else if ( num == 100 ) return "One Hundred";
        else if( num < 1000 ){
            sb.append( func(num/100) );
            sb.append(" Hundred");
            if(num%100 != 0) sb.append(" ");
            sb.append( func(num%100) );
        }
        else if( num == 1000) return "One Thousand";
        else if( num < 1000000){
            sb.append( func(num/1000) );
            sb.append(" Thousand");
            if(num%1000 != 0) sb.append(" ");
            sb.append( func(num%1000) );
        }
        else if( num == 1000000) return "One Million";
        else if( num < 1000000000){
            sb.append( func(num/1000000) );
            sb.append(" Million");
            if(num%1000000 != 0) sb.append(" ");
            sb.append( func(num%1000000) );
        }
        else if( num == 1000000000 ) return "One Billion";
        else{//num = []
            sb.append( func(num/1000000000) );
            sb.append(" Billion");
            if(num%1000000000 != 0) sb.append(" ");
            sb.append( func(num%1000000000) );
        }
        return sb.toString();
    }
}
