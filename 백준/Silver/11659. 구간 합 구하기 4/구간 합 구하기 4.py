"""
[구간합 구하기]
1. s부터 e까지 구간합 구하기: sum(arr[s-1:e])
"""

import sys
input = sys.stdin.readline

N, M = map(int, input().split())
nums = list(map(int, input().split()))
S = [0]*(N+1)
for i in range(1, N+1):
    S[i] = S[i-1]+nums[i-1]

for _ in range(M):
    start, end = map(int, input().split())
    print(S[end]-S[start-1])