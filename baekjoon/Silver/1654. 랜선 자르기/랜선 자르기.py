"""
[이진 탐색]
1. 갖고 있는 최소 길이의 랜선의 길이를 end로 두고 수행
2. start(1)부터 end(min) 범위에서 이진 탐색 수행
3. 각 랜선을 mid로 나눴을 때 몫의 합이 N 이상인 최대 start 구하기
"""

import sys
input = sys.stdin.readline

K, N = map(int, input().split())
line = []
m = 0
for i in range(K):
    line.append(int(input()))
    m = max(m, line[i])

def line_count(l):
    c = 0
    for i in line:
        c += (i//l)
    return c

start = 1
end = m
ans = 0
while start<=end:
    mid = (start+end)//2
    count = line_count(mid)
    if count >= N:
        ans=max(ans, mid)
        start = mid + 1
    else:
        end = mid - 1
print(ans)