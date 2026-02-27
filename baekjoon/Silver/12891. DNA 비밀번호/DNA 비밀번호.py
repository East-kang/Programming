"""
[투 포인터 활용]
1. index 활용
2. 우측으로 옮기면서 첫 항목 감소, 마지막 항목 증가 시킴
"""

import sys
input = sys.stdin.readline

S, P = map(int, input().split())
str = input()
DNA = ['A', 'C', 'G', 'T']
rule = list(map(int, input().split()))  # 0:A, 1:C, 2:G, 3:T
my = [0]*4

s = 0
count = 0
OK = False

for i in range(P-1):
    my[DNA.index(str[i])] += 1
    
for i in range(S-P+1):
    my[DNA.index(str[i+P-1])] += 1
    for j in range(4):
        if my[j] < rule[j]:
            OK = False
            break
        else:
            OK = True
    if OK:
        count += 1
    my[DNA.index(str[i])] -= 1

print(count)