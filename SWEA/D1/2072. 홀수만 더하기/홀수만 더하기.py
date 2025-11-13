T = int(input())
ans = [0] * T
for i in range(T):
    nums = list(map(int, input().split()))
    for n in nums:
        if n % 2 == 1:
            ans[i] += n

for i in range(T):
    print("#%d"%(i+1), ans[i])