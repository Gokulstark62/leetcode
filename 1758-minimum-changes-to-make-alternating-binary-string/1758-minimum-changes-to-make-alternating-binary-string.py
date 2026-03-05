class Solution(object):
    def minOperations(self, s):
        prev = '0'
        c1 = 0
        for i in range(len(s)):
            if s[i] != prev:
                c1 += 1
            prev = '1' if prev == '0' else '0'
        prev = '1'
        c2 = 0
        for i in range(len(s)):
            if s[i] != prev:
                c2 += 1
            prev = '1' if prev == '0' else '0'
        return min(c1, c2)
            
        