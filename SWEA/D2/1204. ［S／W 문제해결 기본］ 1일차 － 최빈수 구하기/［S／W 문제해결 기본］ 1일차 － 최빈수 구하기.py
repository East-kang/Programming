T = int(input())
for i in range(T):
    N = int(input())
    nums = list(map(int, input().split()))
    ans = {i: 0 for i in range(101)}
    
    for n in nums:
        ans[n] += 1
    m = max(ans.values())
    for j in range(100, -1, -1):
        if ans[j] == m:
            print(f"#{N} {j}")