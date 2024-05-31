class Solution {
    public int titleToNumber(String columnTitle) {
        
        //columnNumber -> title is decimal -> 26 based number(1-26) => (0 -25)
        //title -> columnNumber is 26 base -> decimal base(0-9)

        int len = columnTitle.length();
        int i = 0,ans = 0;
        while(i < len){

            char c = columnTitle.charAt(i);
            int mul = c - 'A' + 1;
            ans += (int)Math.pow(26,(len - i - 1)) * mul; 
            i++;           
        }

        return ans;
    }
}