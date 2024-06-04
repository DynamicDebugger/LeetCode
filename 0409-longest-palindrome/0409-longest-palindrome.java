class Solution {
    public int longestPalindrome(String s) {
        int n = s.length() - 1;
        int len = 0;
        if(n == 0) return 1;
        Map<Character,Integer> map = new HashMap<>();

        //Calculate the frequency of the each character in the string
        for(int i = 0 ; i <= n ; i++){
            char c = s.charAt(i);

            if(!map.containsKey(c)){
                map.put(c,1);
                continue;
            }
            map.put(c,map.get(c)+1);
        }
        
        boolean hasOdd = false;

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            int count = e.getValue();
            if (count % 2 == 0) {
                len += count;
            } else {
                len += count - 1;  // add the even part of the odd count
                hasOdd = true;
            }
        }

        if (hasOdd) {
            len += 1;  // add one odd character to the center of the palindrome
        }
        return len;
    }
    
}