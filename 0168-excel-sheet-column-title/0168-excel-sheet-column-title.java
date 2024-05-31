class Solution {
    public String convertToTitle(int columnNumber) {
        
        int n = columnNumber;
        StringBuilder str = new StringBuilder();

        while(n > 0){
            
            n--;
            int rem = n % 26;
            char c = (char) (rem +  'A') ;
            str.append(c);
            n /= 26; 
        }
        return str.reverse().toString();
    }
}