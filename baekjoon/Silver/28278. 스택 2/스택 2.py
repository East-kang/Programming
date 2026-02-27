"""
[Stack]
1 X: s.append(X)
2: print(stack.pop()) if s else print(-1)
3: print(len(stack))
4: print(0) if stack else print(1)
5: print(stack[len(s)-1]) if stack else print(-1)
"""
import sys
input = sys.stdin.readline

N = int(input())
s = []
count = 0
for _ in range(N):
    arr = list(map(int, input().split()))
    match arr[0]:
        case 1:
            s.append(arr[1])
        case 2:
            print(s.pop()) if s else print(-1)
        case 3:
            print(len(s))
        case 4:
            print(0) if s else print(1)
        case 5:
            print(s[len(s)-1]) if s else print(-1)