"""
[Stack]
1. '('는 append / ')'는 pop
2. ')'일 때 stack 비어있거나, 마지막에 잔여 값이 있다면 NO
"""

import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    ps = input().strip()
    s = []
    VPS = True
    for i in range(len(ps)):
        if ps[i] == '(':
            s.append(ps[i])
        else:
            if s:
                s.pop()
            else:
                VPS = False
                break
    if VPS and not s:
        print("YES")
    else:
        print("NO")