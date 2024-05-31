class Solution {
    public int strStr(String haystack, String needle) {
        return searchText(haystack, needle);
    }
    
	int[] lps; 
	public void constructLPS(String pattern) {
		
		int len = pattern.length();
		
		lps = new int[len];
		
		int i = 1 , j = 0;
		
		while(i < len) {
			
			if(pattern.charAt(i) == pattern.charAt(j)) {
				j++;
				lps[i] = j;
				i++;
			}else {
				
				if(j != 0) {
					j = lps[j-1];
				}else {
					lps[i] = 0;
					i++;
				}
			}
		}
	}
	
	public int searchText(String text,String pattern) {
		
		constructLPS(pattern);
		int i = 0 , j = 0;
		int n1 = text.length(), n2 = pattern.length();
		
		while(i < n1) {
			
			if(text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			}
			if(j == n2) return (i - j) ;
			else if(i < n1 && text.charAt(i) != pattern.charAt(j)){
				
				if(j != 0) {
					j = lps[j - 1];
				}else {
					i++;
				}
			}
		}
		return -1 ;
	}
}