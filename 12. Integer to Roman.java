class Solution {
    public String intToRoman(int num) {
        String[] fourth = {"", "M", "MM", "MMM"};
        String[] third = {"","C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] second = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] first = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        StringBuilder sb = new StringBuilder();
        sb.append(fourth[num / 1000]);  num -= 1000 * (num / 1000);
        sb.append(third[num / 100]);    num -= 100 * (num / 100);
        sb.append(second[num / 10]);    num -= 10 * (num / 10);
        sb.append(first[num % 10]);
        return sb.toString();
    }
}
