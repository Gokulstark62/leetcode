class Solution:
    def largestSubmatrix(self, matrix: List[List[int]]) -> int:
        m, n = len(matrix), len(matrix[0])
        ans = 0
        for i in range(1, m):
            for j in range(n):
                if matrix[i][j] == 1:
                    matrix[i][j] += matrix[i - 1][j]

        for i in range(m):
            matrix[i].sort(reverse=True)

            for width in range(1, n + 1):
                h = matrix[i][width - 1]
                ans = max(ans, h * width)

        return ans