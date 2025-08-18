class Solution(object):
    def judgePoint24(self, cards):
        """
        :type cards: List[int]
        :rtype: bool
        """
        EPS = 1e-6
        def isclose(a, b, tol=EPS):
            return abs(a - b) < tol

        def dfs(nums):
            if len(nums) == 1:
                return isclose(nums[0], 24.0)

            n = len(nums)
            for i in range(n):
                for j in range(i + 1, n):
                    a, b = nums[i], nums[j]
                    rest = [nums[k] for k in range(n) if k != i and k != j]

                    candidates = [
                        a + b,
                        a - b,
                        b - a,
                        a * b,
                    ]
                    if abs(b) > EPS:
                        candidates.append(a / b)
                    if abs(a) > EPS:
                        candidates.append(b / a)

                    for val in candidates:
                        if dfs(rest + [val]):
                            return True
            return False

        return dfs([float(x) for x in cards])