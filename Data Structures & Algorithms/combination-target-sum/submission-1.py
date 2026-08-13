class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []
        subset = []
        def dfs(i, total):
            if total == target:
                if subset not in res:
                    res.append(subset.copy())
                return
            if total > target:
                return
            if i >= len(nums):
                return

            subset.append(nums[i])
            total += nums[i]
            dfs(i, total)
            subset.pop()
            total -= nums[i]
            dfs(i + 1, total)
        
        dfs(0, 0)
        return res
