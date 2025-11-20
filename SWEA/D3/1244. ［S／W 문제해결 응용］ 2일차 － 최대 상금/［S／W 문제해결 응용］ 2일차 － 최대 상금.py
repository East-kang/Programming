"""
[완전 탐색 + BFS]
1. 완전 탐색: 가능한 조합 전부 탐색
2. BFS: 교환 횟수를 Level 순으로 전부 탐색
"""

T = int(input())
for C in range(1, T + 1):
    num, changes = input().split()
    changes = int(changes)
    n = len(num)
    current_set = {num}

    for _ in range(changes):
        next_set = set()
        for s in current_set:
            digits = list(s)
            for i in range(n-1):
                for j in range(i+1, n):
                    digits[i], digits[j] = digits[j], digits[i]
                    next_set.add(''.join(digits))
                    digits[i], digits[j] = digits[j], digits[i]
        current_set = next_set
    ans = max(current_set)
    print(f"#{C} {ans}")