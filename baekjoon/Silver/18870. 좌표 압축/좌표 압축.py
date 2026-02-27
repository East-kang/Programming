import sys

N = int(sys.stdin.readline())
X_arr = list(map(int, sys.stdin.readline().split()))

arr = sorted(set(X_arr))
dic = {arr[i]: i for i in range(len(arr))}
for i in X_arr:
    print(dic[i], end=" ")