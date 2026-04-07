class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        ans = []

        for r in range(2):
            for i in nums:
                ans.append(i)
        
        return ans