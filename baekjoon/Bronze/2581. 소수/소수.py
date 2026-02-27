def prime_number(x):
    if x < 2:
        return False
    elif x == 2:
        return True

    for j in range(2, int((x**0.5))+1):
        if x%j==0:
            return False
    return True

M=int(input())
N=int(input())
sum=0
min=N

for i in range(N, M-1, -1):
    if prime_number(i):
        sum+=i
        min=i

if sum==0:
    print(-1)
else:
    print(sum)
    print(min)