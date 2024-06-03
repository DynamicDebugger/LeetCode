class Solution {
    public int appendCharacters(String s, String t) {
        int n1 = s.length(), n2 = t.length();

        int i = 0 ,j = 0;
        while(i < n1 && j < n2){

            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }

        return n2 - j;
        
    }
}