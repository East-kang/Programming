import sys

N = int(sys.stdin.readline())
arr = []
for i in range(N):
    arr.append(list(map(int, sys.stdin.readline().split())))
arr.sort()

for i in range(N):
    print(arr[i][0], arr[i][1])