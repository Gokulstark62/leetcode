class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        total_sum = sum(nums)
        if abs(target) > total_sum or (total_sum + target) % 2 != 0:
            return 0
        
        target_subset_sum = (total_sum + target) // 2
        n = len(nums)
        dp = [[0] * (target_subset_sum + 1) for _ in range(n + 1)]
        
        for i in range(n + 1):
            dp[i][0] = 1
            
        for i in range(1, n + 1):
            for j in range(target_subset_sum + 1):
                if nums[i-1] <= j:
                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j]
                    
        return dp[n][target_subset_sum]