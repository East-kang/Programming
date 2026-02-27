import sys
input = sys.stdin.readline

T = int(input().strip())
ans = []
for i in range(T):
    A, B = map(int, input().strip().split())
    result = A * B
    for i in range(min(A, B), 1, -1):
        if A % i == 0 and B % i == 0:
            result //= i
            break
        
    ans.append(result)
for i in ans:
    print(i)