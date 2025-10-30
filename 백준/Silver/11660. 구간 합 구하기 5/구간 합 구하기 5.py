"""
[부분 합 활용 문제]
1. 각 행마다 세로로 부분 합 저장
2. 구간 끝 부분 합끼리 더하고 구간 시작까지 부분 합 빼기
"""

import sys
input = sys.stdin.readline

N, M = map(int, input().split())
S = [[0]*(N+1) for _ in range(N+1)]

i = 1
for _ in range(1, N+1):
    arr = list(map(int, input().split()))
    for j in range(N):
        S[j+1][i] = S[j][i] + arr[j]
    i += 1

for _ in range(M):
    x1, y1, x2, y2 = map(int, input().split())
    print(sum(S[y2][x1:x2+1])-sum(S[y1-1][x1:x2+1]))