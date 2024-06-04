class Solution {
    public boolean isLongPressedName(String name, String typed) {
        
        int n = name.length(),m = typed.length();
        int i = 0 , j = 0;

        while(j < m){


            if(i < n && name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
            }else if(i > 0 && name.charAt(i - 1) == typed.charAt(j)){
                j++;
            }else{
                return false;
            }

        }

        return i == n;
    }
}