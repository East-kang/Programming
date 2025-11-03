"""
[투 포인터]
1. 양 포인터 지정 후 범위 좁히면서 0과 가까운 값 찾기
"""

import sys
input = sys.stdin.readline
N = int(input())
nums = list(map(int, input().split()))

start = 0
end = N-1
m = 2000000001

while start<end:
    s = nums[start]+nums[end]
   
    m = min(m, abs(s))
    if m == abs(s):
        ans = [nums[start], nums[end]]
        
    if s == 0:
        print(nums[start], nums[end])
        exit(0)
    if s > 0:
        end -= 1
    else:
        start += 1
    
print(ans[0], ans[1])