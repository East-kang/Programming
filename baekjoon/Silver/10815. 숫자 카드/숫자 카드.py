import sys

N = int(sys.stdin.readline())
arr1 = set(map(int, sys.stdin.readline().split()))

M = int(sys.stdin.readline())
arr2 = list(map(int, sys.stdin.readline().split()))

for i in arr2:
    print(1 if i in arr1 else 0, end = ' ')