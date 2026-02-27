"""
[이진 탐색]
1. 적어도 X번 더 이기면 승률은 무조건 변함
2. start = 1, end = X로 이진 탐색
"""

import sys
input = sys.stdin.readline

X, Y = map(int, input().split())

def score(x, y):
    return (y*100)//x

start = 1
end = X
Z = score(X, Y)

while start<=end:
    mid = (start+end)//2
    s = score(X+mid, Y+mid)
    if s > Z:
        end = mid - 1
    else:
        start = mid + 1
if score(X+start, Y+start) > Z:
    print(start)
else:
    print(-1)