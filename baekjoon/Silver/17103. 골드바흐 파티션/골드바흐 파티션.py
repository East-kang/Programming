import sys
input = sys.stdin.readline

prime = []
check = [0] * 1000001
check[0] = 1
check[1] = 1

for i in range(2, 1000001):
    if check[i] == 0:
        prime.append(i)
        for j in range(2 * i, 1000001, i):
            check[j] = 1

T = int(input().strip())

for _ in range(T):
    count = 0
    N = int(input().strip())
    
    for i in prime:
        if i > N // 2:
            break
        else:
            if not check[N - i]:
                count += 1
    print(count)