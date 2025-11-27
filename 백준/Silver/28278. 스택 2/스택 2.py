"""
[Stack]
1 X: s.append(X) / count += 1
2: print(stack.pop(count-1)) if s else print("1") / count -= 1
3: print(count)
4: print("1") if count == 0 else print("0")
5: print("1") if count == 0 else print(stack[count-1])
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
            count += 1
        case 2:
            print(s.pop(count-1)) if count > 0 else print("-1")
            count = count - 1 if count > 0 else 0
        case 3:
            print(count)
        case 4:
            print("1") if count == 0 else print("0")
        case 5:
            print("-1") if count == 0 else print(s[count-1])