def counting(a, start_x, start_y):
    sum1, sum2 = 0, 0
    for i in range(start_y, start_y+8):
        for j in range(start_x, start_x+8):
            if (i + j) % 2 == 0:
                if a[i][j]=='W':
                    sum1 += 1
                else:
                    sum2 += 1
            else:
                if a[i][j]=='B':
                    sum1 += 1
                else:
                    sum2 += 1
    return max(sum1, sum2)

N, M = map(int, input().split())
sum1, sum2 = 0, 0
a = [[0 for j in range(M)] for i in range(N)]
b = []
for i in range(0, N):
    a[i] = list(input())

for i in range(0, N-7):
    for j in range(0, M-7):
        b.append(counting(a, j, i))
print(64-max(b))