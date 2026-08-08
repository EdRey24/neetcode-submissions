class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        groups = {}
        for word in strs:
            anagram = "".join(sorted(word))
            if anagram not in groups:
                groups[anagram] = []
            groups[anagram].append(word)
        
        res = []
        for anagrams in groups.values():
            res.append(anagrams)
        
        return res
