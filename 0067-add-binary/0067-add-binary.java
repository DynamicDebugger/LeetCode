class Solution {
    public String addBinary(String a, String b) {
        int n1 = a.length() - 1;
        int n2 = b.length() - 1;
        int carry = 0;
        StringBuilder str = new StringBuilder();

        while(n1 >= 0 || n2 >= 0 || carry > 0) {
            int sum = carry;
            if(n1 >= 0) sum += a.charAt(n1--) - '0';
            if(n2 >= 0) sum += b.charAt(n2--) - '0';
            str.append(sum % 2);
            carry = sum / 2;
        }

        return str.reverse().toString();
    }
}