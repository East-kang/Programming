N=int(input())
count, num = 0, 0

a=list(map(int, input().split()))

for i in range(N):
    if a[i]>1:
        for j in range(2, a[i]):
            if a[i]%j==0:
                num=1
                break
        if num==0:
            count+=1
        else:
            num=0
print(count)