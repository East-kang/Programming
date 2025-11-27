"""
[Stack]
1. 0이면 pop
"""

import sys
input = sys.stdin.readline

K = int(input())
s = []
for _ in range(K):
    num = int(input())
    if num == 0:
        if s:
            s.pop()
        continue
    s.append(num)
print(sum(s))