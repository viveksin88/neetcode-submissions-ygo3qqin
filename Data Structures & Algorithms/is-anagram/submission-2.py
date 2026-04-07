class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        
        sMap = {}
        tMap = {}

        for c in s:
            sMap[c] = sMap.get(c, 0) + 1
        
        for c in t:
            tMap[c] = tMap.get(c, 0) + 1
        
        for k, v in sMap.items():
            if k not in tMap or sMap[k] != tMap[k]:
                return False
        return True
                