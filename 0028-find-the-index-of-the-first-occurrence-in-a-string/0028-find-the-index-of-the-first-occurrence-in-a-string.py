class Solution(object):
    def strStr(self, haystack, needle):
        if(len(needle) > len(haystack)):
            return -1

        i = 0
        while i <= len(haystack) - len(needle):
            s = haystack[i:i+len(needle)]
            if s == needle:
                return i
            i+=1
        
        return -1