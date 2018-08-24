public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, n1 = 0, n2 = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry > 0; i--, j--) {
            n1 = 0;
            n2 = 0;
            if ( i >= 0 ) n1 = num1.charAt(i) - '0';
            if ( j >= 0 ) n2 = num2.charAt(j) - '0';
            int sum = n1 + n2 + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            }
            else{
                carry = 0;
            }
            sb.append(sum);
        }
        return sb.reverse().toString();
    }
}
