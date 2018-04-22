class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        char[] str = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int sum = 0;
        for ( int i = 0; i < len; i++){
            if( i == len - 1 || map.get(str[i]) >= map.get(str[i+1]) ){
                sum += map.get(str[i]);
            }
            else{
                sum -= map.get(str[i]);
            }
        }
        return sum;
    }
}
