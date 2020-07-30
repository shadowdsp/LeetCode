# 用数学归纳法证明对任意一个整数最大的拆分形式为 n = 2^p * 3^q (n >= 3, p, q为自然数)，
# 并且q应该尽可能大（理由：如果q减少2，则p要增加3，而2^3 < 3^2，因此应该尽可能增加q）。

class Solution:
    def integerBreak(self, n: int) -> int:
        if n <= 3: return n - 1
        a, b = n // 3, n % 3
        if b == 0:
            return int(math.pow(3, a))
        if b == 1:
            return int(math.pow(3, a - 1) * 4)
        return int(math.pow(3, a) * 2)
