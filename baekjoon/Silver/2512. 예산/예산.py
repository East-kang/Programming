"""
[이진 탐색]
1. 예산요청 총합이 전체 국가예산을 넘는지 확인
2. 전체 국가 예산을 N으로 나눈 값이 균등 금액
3. 균등 금액을 넘는
"""

import sys
input = sys.stdin.readline
N = int(input())
arr = list(map(int, input().split()))
M = int(input())
        
start = M//N
end = max(arr)
ans = 0
    
while start<=end:
    mid = (start+end)//2
    s = 0
    for i in arr:
        if i<=mid:
            s += i
        else:
            s += mid
    if s > M:
        end = mid - 1
    else:
        
        start = mid + 1
        ans = max(ans, mid)

print(ans)