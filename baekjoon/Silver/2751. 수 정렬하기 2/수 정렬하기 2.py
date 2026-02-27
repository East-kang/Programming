import sys
N = int(sys.stdin.readline())
a = []
for i in range(N):
    x = int(sys.stdin.readline())
    a.append(x)
a.sort()

for i in range(N):
    print(a[i])